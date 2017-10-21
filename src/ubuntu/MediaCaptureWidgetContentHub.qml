/*
 *
 * Copyright 2013 Canonical Ltd.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/
import QtQuick 2.0

import Ubuntu.Components 0.1
import Ubuntu.Content 0.1

Rectangle {
    id: ui
    property list<ContentItem> importItems
    property var activeTransfer
    visible: true
    anchors.fill: parent
    ContentPeerPicker {
        id: peerPicker
        anchors.fill: parent
        contentType: ContentType.Videos
        handler: ContentHandler.Source
        visible: true
        onPeerSelected: {
            peer.selectionType = ContentTransfer.Single
            peerPicker.visible = false
            activeTransfer = peer.request(store)
        }
        onCancelPressed: {
            ui.visible = false
            root.exec("Capture", "cancel");
        }
    }
    ContentStore {
        id: store
        scope: ContentScope.App
    }
    ContentTransferHint {
        id: transferHint
        anchors.fill: parent
        activeTransfer: ui.activeTransfer
    }
    Connections {
        target: ui.activeTransfer
        onStateChanged: {
            if (ui.activeTransfer.state === ContentTransfer.Aborted) {
                ui.visible = false
                root.exec("Capture", "cancel");
                return;
            }
            if (ui.activeTransfer.state === ContentTransfer.Charged) {
                var capture = root.plugin('Capture');

                if (ui.state == 'camera') {
                    var path = capture.generateLocation("jpg");
                    capture.renameFile(String(ui.activeTransfer.items[0].url).substr('file://'.length), path);
                    capture.onImageSaved(path);
                    ui.visible = false
                    ui.activeTransfer.finalize();
                } else {
                    var path = capture.generateLocation("mp4");
                    capture.copyFile(String(ui.activeTransfer.items[0].url).substr('file://'.length), path);
                    capture.onVideoRecordEnd(path);
                    ui.activeTransfer.finalize();
                    ui.visible = false
                }
            }
        }
    }
    states: [
        State {
            name: "videoRecording"
            StateChangeScript {
                script: {
                    peerPicker.contentType = ContentType.Videos
                }
            }
        },
        State {
            name: "camera"
            StateChangeScript {
                script: {
                    peerPicker.contentType = ContentType.Pictures
                }
            }
        }
    ]
}
