<!---
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.
-->

# org.apache.cordova.media-capture

This plugin provides access to the device's audio, image, and video capture capabilities.

**警告**: イメージ、ビデオ、またはデバイスのカメラやマイクからの音声の収集と利用を重要なプライバシーの問題を発生させます。 アプリのプライバシー ポリシーは、アプリがそのようなセンサーを使用する方法と、記録されたデータは他の当事者と共有かどうかを議論すべきです。 さらに、カメラまたはマイクのアプリの使用がない場合明らかに、ユーザー インターフェイスで、前に、アプリケーションにアクセスするカメラまたはマイクを (デバイスのオペレーティング システムしない場合そう既に) - 時間のお知らせを提供する必要があります。 その通知は、上記の (例えば、 **[ok]**を**おかげで**選択肢を提示する) によってユーザーのアクセス許可を取得するだけでなく、同じ情報を提供する必要があります。 いくつかのアプリのマーケットプ レース - 時間の通知を提供して、カメラまたはマイクにアクセスする前にユーザーからアクセス許可を取得するアプリをする必要がありますに注意してください。 詳細については、プライバシーに関するガイドを参照してください。

## インストール

    cordova plugin add org.apache.cordova.media-capture
    

## サポートされているプラットフォーム

*   アマゾン火 OS
*   アンドロイド
*   ブラックベリー 10
*   iOS
*   Windows Phone 7 と 8
*   Windows 8

## オブジェクト

*   キャプチャ
*   CaptureAudioOptions
*   CaptureImageOptions
*   CaptureVideoOptions
*   CaptureCallback
*   CaptureErrorCB
*   ConfigurationData
*   メディアファイル
*   MediaFileData

## メソッド

*   capture.captureAudio
*   capture.captureImage
*   capture.captureVideo
*   MediaFile.getFormatData

## プロパティ

*   **supportedAudioModes**: デバイスでサポートされている形式の録音。（ConfigurationData[])

*   **supportedImageModes**: 記録画像サイズとデバイスでサポートされている形式です。（ConfigurationData[])

*   **supportedVideoModes**: 記録のビデオ解像度とデバイスでサポートされている形式です。（ConfigurationData[])

## capture.captureAudio

> オーディオ レコーダー アプリケーションを起動し、キャプチャしたオーディオ クリップ ファイルに関する情報を返します。

    navigator.device.capture.captureAudio(
        CaptureCB captureSuccess, CaptureErrorCB captureError,  [CaptureAudioOptions options]
    );
    

### 説明

オーディオ録音デバイスの既定のオーディオ録音アプリケーションを使用してキャプチャする非同期操作を開始します。 操作を単一のセッションで複数の録音をキャプチャするデバイスのユーザーことができます。

キャプチャ操作が終了、ユーザー アプリケーション、または録音で指定された最大数の録音が終了すると `CaptureAudioOptions.limit` に達した。 いいえの場合 `limit` パラメーターの値が指定されて、既定の 1 つ (1)、キャプチャ操作終了後、ユーザーが単一のオーディオ クリップを録音します。

キャプチャ操作が完了すると、 `CaptureCallback` の配列を実行 `MediaFile` オーディオ クリップ ファイルをキャプチャしてそれぞれを記述するオブジェクトします。 オーディオ クリップをキャプチャする前に、ユーザーが操作を終了した場合、 `CaptureErrorCallback` で実行する、 `CaptureError` オブジェクト、特色、 `CaptureError.CAPTURE_NO_MEDIA_FILES` のエラー コード。

### サポートされているプラットフォーム

*   アマゾン火 OS
*   アンドロイド
*   ブラックベリー 10
*   iOS
*   Windows Phone 7 と 8
*   Windows 8

### 例

    // capture callback
    var captureSuccess = function(mediaFiles) {
        var i, path, len;
        for (i = 0, len = mediaFiles.length; i < len; i += 1) {
            path = mediaFiles[i].fullPath;
            // do something interesting with the file
        }
    };
    
    // capture error callback
    var captureError = function(error) {
        navigator.notification.alert('Error code: ' + error.code, null, 'Capture Error');
    };
    
    // start audio capture
    navigator.device.capture.captureAudio(captureSuccess, captureError, {limit:2});
    

### iOS の癖

*   iOS does not have a default audio recording application, so a simple user interface is provided.

### Windows Phone 7 と 8 癖

*   Windows Phone 7 シンプルなユーザー インターフェイスが提供されるので、既定のオーディオ録音アプリケーションはありません。

## CaptureAudioOptions

> オーディオ キャプチャの構成オプションをカプセル化します。

### プロパティ

*   **limit**: The maximum number of audio clips the device user can record in a single capture operation. The value must be greater than or equal to 1 (defaults to 1).

*   **duration**: The maximum duration of an audio sound clip, in seconds.

### 例

    // limit capture operation to 3 media files, no longer than 10 seconds each
    var options = { limit: 3, duration: 10 };
    
    navigator.device.capture.captureAudio(captureSuccess, captureError, options);
    

### Amazon Fire OS Quirks

*   The `duration` parameter is not supported. Recording lengths cannot be limited programmatically.

### Android の癖

*   `duration`パラメーターはサポートされていません。長さの記録プログラムで限定することはできません。

### ブラックベリー 10 癖

*   `duration`パラメーターはサポートされていません。長さの記録プログラムで限定することはできません。
*   The `limit` parameter is not supported, so only one recording can be created for each invocation.

### iOS の癖

*   The `limit` parameter is not supported, so only one recording can be created for each invocation.

## capture.captureImage

> カメラ アプリケーションを起動し、キャプチャしたイメージ ファイルに関する情報を返します。

    navigator.device.capture.captureImage(
        CaptureCB captureSuccess, CaptureErrorCB captureError, [CaptureImageOptions options]
    );
    

### 説明

デバイスのカメラ アプリケーションを使用して画像をキャプチャする非同期操作を開始します。操作では、単一のセッションで 1 つ以上のイメージをキャプチャすることができます。

キャプチャ操作終了いずれかのユーザーが閉じると、カメラ アプリケーションまたは録音で指定された最大数 `CaptureAudioOptions.limit` に達した。 場合ない `limit` 値が指定されて、既定の 1 つ (1)、キャプチャ操作終了後、ユーザーは単一のイメージをキャプチャします。

キャプチャ操作が完了したら、それを呼び出す、 `CaptureCB` の配列がコールバック `MediaFile` 各キャプチャされたイメージ ファイルを記述するオブジェクト。 ユーザーは、イメージをキャプチャする前に操作が終了した場合、 `CaptureErrorCB` コールバックで実行する、 `CaptureError` オブジェクトの特色、 `CaptureError.CAPTURE_NO_MEDIA_FILES` エラー コード。

### サポートされているプラットフォーム

*   アマゾン火 OS
*   アンドロイド
*   ブラックベリー 10
*   iOS
*   Windows Phone 7 と 8
*   Windows 8

### Windows Phone 7 の癖

Zune を介してお使いのデバイスが接続されているネイティブ カメラ アプリケーションを呼び出すと、動作しませんし、エラー コールバックを実行します。

### 例

    // capture callback
    var captureSuccess = function(mediaFiles) {
        var i, path, len;
        for (i = 0, len = mediaFiles.length; i < len; i += 1) {
            path = mediaFiles[i].fullPath;
            // do something interesting with the file
        }
    };
    
    // capture error callback
    var captureError = function(error) {
        navigator.notification.alert('Error code: ' + error.code, null, 'Capture Error');
    };
    
    // start image capture
    navigator.device.capture.captureImage(captureSuccess, captureError, {limit:2});
    

## CaptureImageOptions

> イメージ キャプチャの構成オプションをカプセル化します。

### プロパティ

*   **limit**: The maximum number of images the user can capture in a single capture operation. The value must be greater than or equal to 1 (defaults to 1).

### 例

    // limit capture operation to 3 images
    var options = { limit: 3 };
    
    navigator.device.capture.captureImage(captureSuccess, captureError, options);
    

### iOS の癖

*   The **limit** parameter is not supported, and only one image is taken per invocation.

## capture.captureVideo

> ビデオ レコーダー アプリケーションを起動し、キャプチャしたビデオ クリップ ファイルに関する情報を返します。

    navigator.device.capture.captureVideo(
        CaptureCB captureSuccess, CaptureErrorCB captureError, [CaptureVideoOptions options]
    );
    

### 説明

デバイスのビデオ録画アプリケーションを使用してビデオ記録をキャプチャする非同期操作を開始します。操作は、単一のセッションで 1 つ以上の録音をキャプチャすることができます。

キャプチャ操作終了いずれかユーザーがビデオ録画アプリケーションまたは録音で指定された最大数を終了時 `CaptureVideoOptions.limit` に達した。 いいえの場合 `limit` パラメーター値が指定されて、既定の 1 つ （1）、ユーザーは 1 つのビデオ クリップを記録した後にキャプチャ操作が終了しました。

キャプチャ操作が完了したら、それは `CaptureCB` の配列でコールバックを実行します `MediaFile` ビデオ クリップ ファイルをキャプチャしてそれぞれを記述するオブジェクトします。 ユーザーがビデオ クリップをキャプチャする前に操作を終了した場合、 `CaptureErrorCB` コールバックで実行する、 `CaptureError` オブジェクトの特色を `CaptureError.CAPTURE_NO_MEDIA_FILES` エラー コード。

### サポートされているプラットフォーム

*   アマゾン火 OS
*   アンドロイド
*   ブラックベリー 10
*   iOS
*   Windows Phone 7 と 8
*   Windows 8

### 例

    // capture callback
    var captureSuccess = function(mediaFiles) {
        var i, path, len;
        for (i = 0, len = mediaFiles.length; i < len; i += 1) {
            path = mediaFiles[i].fullPath;
            // do something interesting with the file
        }
    };
    
    // capture error callback
    var captureError = function(error) {
        navigator.notification.alert('Error code: ' + error.code, null, 'Capture Error');
    };
    
    // start video capture
    navigator.device.capture.captureVideo(captureSuccess, captureError, {limit:2});
    

### ブラックベリー 10 癖

*   Cordova for BlackBerry 10 attempts to launch the **Video Recorder** application, provided by RIM, to capture video recordings. The app receives a `CaptureError.CAPTURE_NOT_SUPPORTED` error code if the application is not installed on the device.

## CaptureVideoOptions

> ビデオ キャプチャの構成オプションをカプセル化します。

### プロパティ

*   **limit**: The maximum number of video clips the device's user can capture in a single capture operation. The value must be greater than or equal to 1 (defaults to 1).

*   **duration**: The maximum duration of a video clip, in seconds.

### 例

    // limit capture operation to 3 video clips
    var options = { limit: 3 };
    
    navigator.device.capture.captureVideo(captureSuccess, captureError, options);
    

### ブラックベリー 10 癖

*   The **duration** parameter is not supported, so the length of recordings can't be limited programmatically.

### iOS の癖

*   The **limit** parameter is not supported. Only one video is recorded per invocation.

## CaptureCB

> 成功したメディア キャプチャ操作時に呼び出されます。

    function captureSuccess( MediaFile[] mediaFiles ) { ... };
    

### 説明

この関数は成功したキャプチャ操作の完了後に実行します。 いずれかのメディア ファイルをキャプチャすると、この時点で、ユーザーがメディア ・ キャプチャ ・ アプリケーションを終了またはキャプチャ制限に達しています。

各 `MediaFile` オブジェクトにはキャプチャしたメディア ファイルについて説明します。

### 例

    // capture callback
    function captureSuccess(mediaFiles) {
        var i, path, len;
        for (i = 0, len = mediaFiles.length; i < len; i += 1) {
            path = mediaFiles[i].fullPath;
            // do something interesting with the file
        }
    };
    

## CaptureError

> 失敗したメディア キャプチャ操作からの結果のエラー コードをカプセル化します。

### プロパティ

*   **code**: One of the pre-defined error codes listed below.

### 定数

*   `CaptureError.CAPTURE_INTERNAL_ERR`: The camera or microphone failed to capture image or sound.

*   `CaptureError.CAPTURE_APPLICATION_BUSY`： 現在カメラやオーディオのキャプチャのアプリケーション別のキャプチャ要求を提供します。

*   `CaptureError.CAPTURE_INVALID_ARGUMENT`： 無効な API の使用 (例えば、の値 `limit` が 1 未満です)。

*   `CaptureError.CAPTURE_NO_MEDIA_FILES`: The user exits the camera or audio capture application before capturing anything.

*   `CaptureError.CAPTURE_NOT_SUPPORTED`: The requested capture operation is not supported.

## CaptureErrorCB

> メディア キャプチャ操作中にエラーが発生した場合に呼び出されます。

    function captureError( CaptureError error ) { ... };
    

### 説明

この関数でエラーが発生を起動しようとすると、メディアのキャプチャ操作を実行します。 障害シナリオを含めますキャプチャ アプリケーションがビジー状態、キャプチャ操作は既に起こって、または、操作をキャンセルする前にメディア ファイルが自動的にキャプチャされます。

この関数で実行する、 `CaptureError` 、適切なエラーを格納しているオブジェクト`code`.

### 例

    // capture error callback
    var captureError = function(error) {
        navigator.notification.alert('Error code: ' + error.code, null, 'Capture Error');
    };
    

## ConfigurationData

> デバイスがサポートするメディア キャプチャ パラメーターのセットをカプセル化します。

### 説明

デバイスでサポートされているメディアのキャプチャのモードについて説明します。構成データには、MIME の種類、およびビデオやイメージ キャプチャのキャプチャ寸法が含まれます。

MIME の種類は[RFC2046][1]に従う必要があります。例:

 [1]: http://www.ietf.org/rfc/rfc2046.txt

*   `video/3gpp`
*   `video/quicktime`
*   `image/jpeg`
*   `audio/amr`
*   `audio/wav`

### プロパティ

*   **type**: The ASCII-encoded lowercase string representing the media type. (DOMString)

*   **height**: The height of the image or video in pixels. The value is zero for sound clips. (Number)

*   **width**: The width of the image or video in pixels. The value is zero for sound clips. (Number)

### 例

    // retrieve supported image modes
    var imageModes = navigator.device.capture.supportedImageModes;
    
    // Select mode that has the highest horizontal resolution
    var width = 0;
    var selectedmode;
    for each (var mode in imageModes) {
        if (mode.width > width) {
            width = mode.width;
            selectedmode = mode;
        }
    }
    

任意のプラットフォームでサポートされていません。すべての構成データの配列は空です。

## MediaFile.getFormatData

> 取得についての書式情報メディア キャプチャ ファイル。

    mediaFile.getFormatData (MediaFileDataSuccessCB successCallback, [MediaFileDataErrorCB 解り]);
    

### 説明

この関数は、非同期的にメディア ファイルの形式情報を取得しようとします。 かどうかは成功、呼び出します、 `MediaFileDataSuccessCB` コールバックを `MediaFileData` オブジェクト。 この関数を呼び出します、試行が失敗した場合、 `MediaFileDataErrorCB` コールバック。

### サポートされているプラットフォーム

*   アマゾン火 OS
*   アンドロイド
*   ブラックベリー 10
*   iOS
*   Windows Phone 7 と 8
*   Windows 8

### Amazon Fire OS Quirks

API 情報にアクセスするメディア ファイル形式は限られて、それで、必ずしもすべて `MediaFileData` プロパティがサポートされます。

### ブラックベリー 10 癖

ので、すべてのメディア ファイルに関する情報の API を提供しない `MediaFileData` 既定値を持つオブジェクトを返します。

### Android の癖

API 情報にアクセスするメディア ファイル形式は限られて、それで、必ずしもすべて `MediaFileData` プロパティがサポートされます。

### iOS の癖

API 情報にアクセスするメディア ファイル形式は限られて、それで、必ずしもすべて `MediaFileData` プロパティがサポートされます。

## メディアファイル

> メディア キャプチャ ファイルのプロパティをカプセル化します。

### プロパティ

*   **name**: The name of the file, without path information. (DOMString)

*   **fullPath**: The full path of the file, including the name. (DOMString)

*   **type**: The file's mime type (DOMString)

*   **lastModifiedDate**: The date and time when the file was last modified. (Date)

*   **size**: The size of the file, in bytes. (Number)

### メソッド

*   **MediaFile.getFormatData**: Retrieves the format information of the media file.

## MediaFileData

> メディア ファイルの形式情報をカプセル化します。

### プロパティ

*   **codecs**: The actual format of the audio and video content. (DOMString)

*   **bitrate**: The average bitrate of the content. The value is zero for images. (Number)

*   **height**: The height of the image or video in pixels. The value is zero for audio clips. (Number)

*   **width**: The width of the image or video in pixels. The value is zero for audio clips. (Number)

*   **duration**: The length of the video or sound clip in seconds. The value is zero for images. (Number)

### ブラックベリー 10 癖

メディア ファイルの形式情報を提供する API がしないので、 `MediaFileData` によって返されるオブジェクト `MediaFile.getFormatData` 機能次の既定値。

*   **コーデック**： いないサポートしを返します`null`.

*   **ビットレート**： いないサポートし、ゼロを返します。

*   **height**: Not supported, and returns zero.

*   **width**: Not supported, and returns zero.

*   **duration**: Not supported, and returns zero.

### Amazon Fire OS Quirks

以下がサポート `MediaFileData` プロパティ。

*   **コーデック**： いないサポートしを返します`null`.

*   **ビットレート**： いないサポートし、ゼロを返します。

*   **高さ**: サポート: イメージ ファイルやビデオ ファイルのみです。

*   **幅**: サポート: イメージ ファイルやビデオ ファイルのみです。

*   **duration**: Supported: audio and video files only

### Android の癖

以下がサポート `MediaFileData` プロパティ。

*   **コーデック**： いないサポートしを返します`null`.

*   **ビットレート**： いないサポートし、ゼロを返します。

*   **高さ**: サポート: イメージ ファイルやビデオ ファイルのみです。

*   **幅**: サポート: イメージ ファイルやビデオ ファイルのみです。

*   **期間**: サポート: オーディオおよびビデオ ファイルのみです。

### iOS の癖

以下がサポート `MediaFileData` プロパティ。

*   **コーデック**： いないサポートしを返します`null`.

*   **bitrate**: Supported on iOS4 devices for audio only. Returns zero for images and videos.

*   **高さ**: サポート: イメージ ファイルやビデオ ファイルのみです。

*   **幅**: サポート: イメージ ファイルやビデオ ファイルのみです。

*   **期間**: サポート: オーディオおよびビデオ ファイルのみです。