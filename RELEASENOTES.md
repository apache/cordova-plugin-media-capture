<!--
#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
# 
# http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
#  KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#
-->
# Release Notes

### 5.0.0 (Aug 14, 2023)

**Breaking Changes:**

* [GH-274](https://github.com/apache/cordova-plugin-media-capture/pull/274) feat(android)!: bump file & **Android** requirements
* [GH-262](https://github.com/apache/cordova-plugin-media-capture/pull/262) feat(android)!: support API 33+ permissions

**Features:**

* [GH-214](https://github.com/apache/cordova-plugin-media-capture/pull/214) feat(ios): support capture '`quality`' param for videos
* [GH-256](https://github.com/apache/cordova-plugin-media-capture/pull/256) feat(ios): improve `Localizable.strings` & add `FR`

**Fixes:**

* [GH-184](https://github.com/apache/cordova-plugin-media-capture/pull/184) fix(ios): UI issues with main thread and added alert for permission.
* [GH-279](https://github.com/apache/cordova-plugin-media-capture/pull/279) fix(ios): UI sizing of the audio capture controller according to parent view size
* [GH-278](https://github.com/apache/cordova-plugin-media-capture/pull/278) fix(ios): `CAPTURE_APPLICATION_BUSY` error when dismissing modal by swipe
* [GH-197](https://github.com/apache/cordova-plugin-media-capture/pull/197) fix(ios): set type attribute for captured audio
* [GH-232](https://github.com/apache/cordova-plugin-media-capture/pull/232) fix(android): prevent app crash caused by NPE on intent data or `mediaFile`
* [GH-195](https://github.com/apache/cordova-plugin-media-capture/pull/195) fix(MediaFiles): return missing '`lastModified`' and '`end`' attributes
* [GH-212](https://github.com/apache/cordova-plugin-media-capture/pull/212) fix: use single version in `cordovaDependencies`
* [GH-269](https://github.com/apache/cordova-plugin-media-capture/pull/269) fix(ios): set category before creating `AVAudioRecorder`

**Other Changes:**

* [GH-276](https://github.com/apache/cordova-plugin-media-capture/pull/276) dep: bump `@cordova/eslint-config@^5.0.0` w/ lint fix & `package-lock` rebuild
* [GH-270](https://github.com/apache/cordova-plugin-media-capture/pull/270) chore: Update `SUPPORT_QUESTION.md` template
* [GH-252](https://github.com/apache/cordova-plugin-media-capture/pull/252) chore(npm): rebuilt `package-lock`
* [GH-273](https://github.com/apache/cordova-plugin-media-capture/pull/273) ci: sync github action workflow w/ paramedic base configs
* [GH-254](https://github.com/apache/cordova-plugin-media-capture/pull/254) ci: sync workflow with paramedic
* [GH-251](https://github.com/apache/cordova-plugin-media-capture/pull/251) ci(android): update java requirement for `cordova-android@11`

### 4.0.0 (May 25, 2022)

* [GH-238](https://github.com/apache/cordova-plugin-media-capture/pull/238) dep!: bump `cordova-plugin-file@^7.0.0`
* [GH-248](https://github.com/apache/cordova-plugin-media-capture/pull/248) test: remove `cordova-plugin-media` dependency
* [GH-247](https://github.com/apache/cordova-plugin-media-capture/pull/247) chore: bump `cordovaDependencies` next next major cordova requirement
* [GH-246](https://github.com/apache/cordova-plugin-media-capture/pull/246) chore: rebuilt `package-lock` w/ v2
* [GH-192](https://github.com/apache/cordova-plugin-media-capture/pull/192) fix(android): Unify and fix permission check
* [GH-231](https://github.com/apache/cordova-plugin-media-capture/pull/231) ci(ios): update workflow w/ **iOS** 15
* [GH-230](https://github.com/apache/cordova-plugin-media-capture/pull/230) ci: add `action-badge`
* [GH-229](https://github.com/apache/cordova-plugin-media-capture/pull/229) ci: remove `travis` & `appveyor`
* [GH-228](https://github.com/apache/cordova-plugin-media-capture/pull/228) ci: add `gh-actions` workflows
* [GH-200](https://github.com/apache/cordova-plugin-media-capture/pull/200) fix(android): remove unknown permission `android.permission.RECORD_VIDEO`
* [GH-203](https://github.com/apache/cordova-plugin-media-capture/pull/203) ci: add node-14.x to workflow
* [GH-193](https://github.com/apache/cordova-plugin-media-capture/pull/193) chore: clean up `package.json`
* [GH-189](https://github.com/apache/cordova-plugin-media-capture/pull/189) ci(travis): update osx xcode image
* [GH-177](https://github.com/apache/cordova-plugin-media-capture/pull/177) breaking(ios): remove code warnings
* [GH-188](https://github.com/apache/cordova-plugin-media-capture/pull/188) ci(travis): updates **Android** API level
* [GH-180](https://github.com/apache/cordova-plugin-media-capture/pull/180) chore: adds `package-lock` file
* [GH-179](https://github.com/apache/cordova-plugin-media-capture/pull/179) refactor(eslint): use `cordova-eslint` /w fix
* [GH-178](https://github.com/apache/cordova-plugin-media-capture/pull/178) chore(npm): use short notation in `package.json`
* chore(asf): update git notification settings
* Update CONTRIBUTING.md
* [GH-165](https://github.com/apache/cordova-plugin-media-capture/pull/165) ci: updates Node.js versions
* [GH-164](https://github.com/apache/cordova-plugin-media-capture/pull/164) chore(npm): improve ignore list
* [GH-161](https://github.com/apache/cordova-plugin-media-capture/pull/161) Small javadoc fix
* ci(travis): upgrade to node 8

### 3.0.3 (Jun 19, 2019)

-   fix(android): Catch ActivityNotFoundException ([#104](https://github.com/apache/cordova-plugin-media-capture/issues/104)) ([`f69ba2a`](https://github.com/apache/cordova-plugin-media-capture/commit/f69ba2a))
-   fix(android): [CB-14260](https://issues.apache.org/jira/browse/CB-14260) (android) captureImage permission denial on android 8.1 ([#95](https://github.com/apache/cordova-plugin-media-capture/issues/95)) ([`3755f9f`](https://github.com/apache/cordova-plugin-media-capture/commit/3755f9f))
-   docs: remove outdated translations ([`6422b2b`](https://github.com/apache/cordova-plugin-media-capture/commit/6422b2b))
-   build: add `.npmignore` to remove unneeded files from npm package ([`586f917`](https://github.com/apache/cordova-plugin-media-capture/commit/586f917))
-   build: add `.gitattributes` to force LF (instead of possible CRLF on Windows) ([`246ce57`](https://github.com/apache/cordova-plugin-media-capture/commit/246ce57))
-   ci(travis): Update Travis CI configuration for new paramedic ([#134](https://github.com/apache/cordova-plugin-media-capture/issues/134)) ([`f59af25`](https://github.com/apache/cordova-plugin-media-capture/commit/f59af25))
-   chore(github): Add or update GitHub pull request and issue template ([`e5a982e`](https://github.com/apache/cordova-plugin-media-capture/commit/e5a982e))
-   docs: remove JIRA link ([`c3928c8`](https://github.com/apache/cordova-plugin-media-capture/commit/c3928c8))
-   ci(travis): also accept terms for android sdk `android-27` ([`59966ac`](https://github.com/apache/cordova-plugin-media-capture/commit/59966ac))
-   chore(types): Add CaptureError.CAPTURE_PERMISSION_DENIED to type declaration file [#98](https://github.com/apache/cordova-plugin-media-capture/issues/98) ([`eff0128`](https://github.com/apache/cordova-plugin-media-capture/commit/eff0128), [`5fb4917`](https://github.com/apache/cordova-plugin-media-capture/commit/5fb4917))

### 3.0.2 (Apr 12, 2018)
* [CB-13866](https://issues.apache.org/jira/browse/CB-13866): **iOS** fix Camera opens in portrait orientation on iphones

### 3.0.1 (Dec 27, 2017)
* [CB-13707](https://issues.apache.org/jira/browse/CB-13707) Fix to allow 3.0.0 version install (#88)
* Bump cordova-plugin-file dependency to 6.0.0

### 3.0.0 (Dec 15, 2017)
* [CB-13669](https://issues.apache.org/jira/browse/CB-13669) : Remove deprecated plugins

### 2.0.0 (Nov 06, 2017)
* [CB-13520](https://issues.apache.org/jira/browse/CB-13520) (all): Add 'protective' entry to `cordovaDependencies`
* [CB-13266](https://issues.apache.org/jira/browse/CB-13266) (ios): Remove **iOS** usage descriptions
* [CB-13473](https://issues.apache.org/jira/browse/CB-13473) (CI) Removed **Browser** builds from AppVeyor
* [CB-13294](https://issues.apache.org/jira/browse/CB-13294) Remove `cordova-plugin-compat`
* [CB-13299](https://issues.apache.org/jira/browse/CB-13299) (CI) Fix **Android** builds
* [CB-12895](https://issues.apache.org/jira/browse/CB-12895) added `eslint` and removed `jshint`
* [CB-13028](https://issues.apache.org/jira/browse/CB-13028) (CI) **Browser** builds on Travis and AppVeyor
* [CB-12882](https://issues.apache.org/jira/browse/CB-12882) (ios): adds support for permissions checks for `captureVideo` and `captureImage` methods
* [CB-12847](https://issues.apache.org/jira/browse/CB-12847) added `bugs` entry to `package.json`.

### 1.4.3 (Apr 27, 2017)
* [CB-12622](https://issues.apache.org/jira/browse/CB-12622) Added **Android 6.0** build badges to `README`
* [CB-12685](https://issues.apache.org/jira/browse/CB-12685) added `package.json` to tests folder

### 1.4.2 (Feb 28, 2017)
* [CB-12353](https://issues.apache.org/jira/browse/CB-12353) Corrected merges usage in `plugin.xml`
* [CB-12369](https://issues.apache.org/jira/browse/CB-12369) Add plugin typings from `DefinitelyTyped` 
* [CB-12363](https://issues.apache.org/jira/browse/CB-12363) Added build badges for **iOS 9.3** and **iOS 10.0** 
* [CB-12230](https://issues.apache.org/jira/browse/CB-12230) Removed **Windows 8.1** build badges

### 1.4.1 (Dec 07, 2016)
* [CB-12224](https://issues.apache.org/jira/browse/CB-12224) Updated version and RELEASENOTES.md for release 1.4.1
* [CB-10701](https://issues.apache.org/jira/browse/CB-10701) [CB-7117](https://issues.apache.org/jira/browse/CB-7117) android: Add manual test to check getting metadata
* [CB-10489](https://issues.apache.org/jira/browse/CB-10489) Fix for MediaFile.getFormatData / audio recording support
* [CB-10488](https://issues.apache.org/jira/browse/CB-10488) Fix for MediaFile.getFormatData
* [CB-11996](https://issues.apache.org/jira/browse/CB-11996) Added a new manual test to capture multiple images
* [CB-11995](https://issues.apache.org/jira/browse/CB-11995) (android) Do not pass a file URI to the camera
* [CB-11917](https://issues.apache.org/jira/browse/CB-11917) - Remove pull request template checklist item: "iCLA has been submitted…"
* [CB-11832](https://issues.apache.org/jira/browse/CB-11832) Incremented plugin version.

### 1.4.0 (Sep 08, 2016)
* Add mandatory **iOS 10** privacy description for microphone
* [CB-11795](https://issues.apache.org/jira/browse/CB-11795) Add 'protective' entry to cordovaDependencies
* [CB-11821](https://issues.apache.org/jira/browse/CB-11821) (ios) Add mandatory **iOS 10** privacy description
* Plugin uses `Android Log class` and not `Cordova LOG class`
* Add badges for paramedic builds on Jenkins
* [CB-11396](https://issues.apache.org/jira/browse/CB-11396) - Audio Media Capture Crashes if app stores file on external storage
* Add pull request template.
* [CB-11212](https://issues.apache.org/jira/browse/CB-11212) **iOS**: Explicitly set the bundle for images
* [CB-10554](https://issues.apache.org/jira/browse/CB-10554) Implementing plugin `save/restore` API for Android
* [CB-11165](https://issues.apache.org/jira/browse/CB-11165) removed peer dependency
* [CB-10996](https://issues.apache.org/jira/browse/CB-10996) Adding front matter to README.md

### 1.3.0 (Apr 15, 2016)
* Replace `PermissionHelper.java` with `cordova-plugin-compat`
* CB-10670, [CB-10994](https://issues.apache.org/jira/browse/CB-10994) **Android**, Marshmallow permissions
* [CB-10720](https://issues.apache.org/jira/browse/CB-10720) Fixing README for display on Cordova website
* [CB-10636](https://issues.apache.org/jira/browse/CB-10636) Add `JSHint` for plugins
* [CB-10690](https://issues.apache.org/jira/browse/CB-10690) **windows**, fix crash when user cancels/closes photo app

### 1.2.0 (Jan 15, 2016)
* [CB-10100](https://issues.apache.org/jira/browse/CB-10100) updated file dependency to not grab new majors
* [CB-8863](https://issues.apache.org/jira/browse/CB-8863) Fix block usage of self

### 1.1.0 (Nov 18, 2015)
* [CB-10035](https://issues.apache.org/jira/browse/CB-10035) Updated `RELEASENOTES` to be newest to oldest
* Fixing contribute link.
* [CB-9249](https://issues.apache.org/jira/browse/CB-9249) Fix **iOS** warnings in Media Capture plugin
* Document the quality property in **Android** quirks
* Add `CaptureVideoOption` for quality

### 1.0.1 (Jun 17, 2015)
* [CB-9128](https://issues.apache.org/jira/browse/CB-9128) cordova-plugin-media-capture documentation translation: cordova-plugin-media-capture
* fix npm md issue

### 1.0.0 (Apr 15, 2015)
* [CB-8746](https://issues.apache.org/jira/browse/CB-8746) bumped version of file dependency
* [CB-8746](https://issues.apache.org/jira/browse/CB-8746) gave plugin major version bump
* [CB-8747](https://issues.apache.org/jira/browse/CB-8747) updated dependency, added peer dependency
* [CB-8683](https://issues.apache.org/jira/browse/CB-8683) changed plugin-id to pacakge-name
* [CB-8653](https://issues.apache.org/jira/browse/CB-8653) properly updated translated docs to use new id
* [CB-8653](https://issues.apache.org/jira/browse/CB-8653) updated translated docs to use new id
* Use TRAVIS_BUILD_DIR, install paramedic by npm
* docs: added Windows to supported platforms
* [CB-8687](https://issues.apache.org/jira/browse/CB-8687) consolidate manifest targets
* [CB-7963](https://issues.apache.org/jira/browse/CB-7963) Adds support for browser platform
* [CB-8653](https://issues.apache.org/jira/browse/CB-8653) Updated Readme
* [CB-8659](https://issues.apache.org/jira/browse/CB-8659): ios: 4.0.x Compatibility: Remove use of initWebView method
* [CB-8571](https://issues.apache.org/jira/browse/CB-8571) Integrate TravisCI
* [CB-8438](https://issues.apache.org/jira/browse/CB-8438) cordova-plugin-media-capture documentation translation: cordova-plugin-media-capture
* [CB-8538](https://issues.apache.org/jira/browse/CB-8538) Added package.json file

### 0.3.6 (Feb 04, 2015)
* [CB-8351](https://issues.apache.org/jira/browse/CB-8351) ios: Use inline copies of deprecated CDV_IsIpad and CDV_IsIphone5
* [CB-8351](https://issues.apache.org/jira/browse/CB-8351) ios: Stop using (newly) deprecated CDVJSON.h
* [CB-8351](https://issues.apache.org/jira/browse/CB-8351) ios: Use argumentForIndex rather than NSArray extension
* [CB-7977](https://issues.apache.org/jira/browse/CB-7977) Mention deviceready in plugin docs

### 0.3.5 (Dec 02, 2014)
* [CB-7597](https://issues.apache.org/jira/browse/CB-7597) - `Localizable.strings` for Media Capture are in the default template, it should be in the plugin
* [CB-7700](https://issues.apache.org/jira/browse/CB-7700) cordova-plugin-media-capture documentation translation: cordova-plugin-media-capture

### 0.3.4 (Oct 03, 2014)
* [CB-7453](https://issues.apache.org/jira/browse/CB-7453) Adds fallback to m4a audio format when mp3 recording fails.
* [CB-7429](https://issues.apache.org/jira/browse/CB-7429) Fixes image capture manual tests on windows
* [CB-7429](https://issues.apache.org/jira/browse/CB-7429) Move windows8 and windows Proxies into one file
* [CB-7429](https://issues.apache.org/jira/browse/CB-7429) Adds media capture support for windows

### 0.3.3 (Sep 17, 2014)
* Renamed test dir, added nested `plugin.xml`
* added documentation for manual tests
* [CB-6959](https://issues.apache.org/jira/browse/CB-6959) Added manual tests
* [CB-6959](https://issues.apache.org/jira/browse/CB-6959) Port capture tests to plugin-test-framework

### 0.3.2 (Aug 06, 2014)
* ubuntu: fix compler warnings
* ubuntu: support qt 5.2
* [CB-6127](https://issues.apache.org/jira/browse/CB-6127) Updated translations for docs
* [CB-6978](https://issues.apache.org/jira/browse/CB-6978) captureImage() function fails in Android
* [CB-6890](https://issues.apache.org/jira/browse/CB-6890): Fix pluginManager access for 4.0.x branch

### 0.3.1 (Jun 05, 2014)
* Added translations to documentation. Github close #14
* Remove deprecated symbols for iOS < 6
* Fixes captureTasks UI URIs
* [CB-6808](https://issues.apache.org/jira/browse/CB-6808) Add license
* [CB-6706](https://issues.apache.org/jira/browse/CB-6706): Relax dependency on file plugin
* [CB-6491](https://issues.apache.org/jira/browse/CB-6491) add CONTRIBUTING.md

### 0.3.0 (Apr 17, 2014)
* [CB-6152](https://issues.apache.org/jira/browse/CB-6152): [ios, android] Make mediafile compatible with file plugin
* [CB-6385](https://issues.apache.org/jira/browse/CB-6385): Specify file plugin dependency version
* [CB-6212](https://issues.apache.org/jira/browse/CB-6212): [iOS] fix warnings compiled under arm64 64-bit
* [CB-6016](https://issues.apache.org/jira/browse/CB-6016) [BlackBerry10] Add audio capture capability
* [Blackberry10] Add rim xml namespaces declaration
* [CB-6422](https://issues.apache.org/jira/browse/CB-6422) [windows8] use cordova/exec/proxy
* [CB-6460](https://issues.apache.org/jira/browse/CB-6460): Update license headers
* Add NOTICE file

### 0.2.8 (Feb 26, 2014)
* [CB-5202](https://issues.apache.org/jira/browse/CB-5202) Fix video capture crash on Android 4.3+

### 0.2.7 (Feb 05, 2014)
* [ubuntu] request audio/camera/microphone permission
* fixed  cordova cli add capture plugin not work wp
* [CB-5685](https://issues.apache.org/jira/browse/CB-5685) [BlackBerry10] Add access_shared permission

### 0.2.6 (Jan 02, 2014)
* [CB-5658](https://issues.apache.org/jira/browse/CB-5658) Add doc/index.md for Media Capture plugin
* [CB-5569](https://issues.apache.org/jira/browse/CB-5569) Windows8. MediaFile constructor does not exist
* [CB-5517](https://issues.apache.org/jira/browse/CB-5517) Fix the audio capture IO exception by putting it in a runnable

### 0.2.5 (Dec 4, 2013)
* add ubuntu platform
* Added amazon-fireos platform. Change to use amazon-fireos as a platform if user agent string contains 'cordova-amazon-fireos'
* [CB-5291](https://issues.apache.org/jira/browse/CB-5291) - ios - Media Capture Audio - status bar issues under iOS 7
* [CB-5275](https://issues.apache.org/jira/browse/CB-5275): CaptureImage and CaptureVideo have runnables and CaptureVideo works on 4.2.  Still doesn't work for 4.3

### 0.2.4 (Oct 28, 2013)
* [CB-5199](https://issues.apache.org/jira/browse/CB-5199) - ios - Media Capture - UI issues under iOS 7
* [CB-5128](https://issues.apache.org/jira/browse/CB-5128): added repo + issue tag to `plugin.xml` for media capture plugin
* [CB-5010](https://issues.apache.org/jira/browse/CB-5010) Incremented plugin version on dev branch. 

### 0.2.3 (Oct 9, 2013)
* [CB-4720](https://issues.apache.org/jira/browse/CB-4720): fixed incorrect feature tag in `plugin.xml` for wp
* [CB-4915](https://issues.apache.org/jira/browse/CB-4915) Incremented plugin version on dev branch.

### 0.2.2 (Sept 25, 2013)
* [CB-4889](https://issues.apache.org/jira/browse/CB-4889) bumping&resetting version
* [windows8] commandProxy was moved
* [windows8] commandProxy was moved
* [CB-4889](https://issues.apache.org/jira/browse/CB-4889)
* [CB-4889](https://issues.apache.org/jira/browse/CB-4889) renaming org.apache.cordova.core.media-capture to org.apache.cordova.media-capture and updating dependency
* Rename CHANGELOG.md -> RELEASENOTES.md
* [CB-4847](https://issues.apache.org/jira/browse/CB-4847) iOS 7 microphone access requires user permission - if denied, CDVCapture, CDVSound does not handle it properly
* [CB-4826](https://issues.apache.org/jira/browse/CB-4826) Fix warning using UITextAlignmentCenter
* [CB-4826](https://issues.apache.org/jira/browse/CB-4826) Fix XCode 5 capture plugin warnings
* [CB-4488](https://issues.apache.org/jira/browse/CB-4488) - added manual capture test
* [CB-4764](https://issues.apache.org/jira/browse/CB-4764) Remove reference to DirectoryManager from Capture.java
* [CB-4763](https://issues.apache.org/jira/browse/CB-4763) Use own version of FileHelper.
* [CB-4752](https://issues.apache.org/jira/browse/CB-4752) Incremented plugin version on dev branch.
