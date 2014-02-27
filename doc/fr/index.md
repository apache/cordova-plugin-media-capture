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

Ce plugin permet d'accéder à de l'appareil audio, image et capacités de capture vidéo.

**Avertissement**: collecte et utilisation des images, vidéo ou audio de la caméra ou un microphone de l'appareil soulève des questions importantes de la vie privée. La politique de confidentialité de votre application devrait traiter de la manière dont l'application utilise ces capteurs et du partage des données enregistrées avec d'autres parties ou non. En outre, si l'utilisation de l'application de la caméra ou un microphone n'est pas apparente dans l'interface utilisateur, vous devez fournir un avis juste-à-temps, avant que l'application accède à la caméra ou un microphone (si le système d'exploitation de périphérique n'est pas faire déjà). Cette notice devrait contenir les informations susmentionnées, ainsi que permettre de recueillir l'autorisation de l'utilisateur (par exemple, en offrant les possibilités **OK** et **Non merci**). Notez que certains magasins d'applications peuvent exiger la présence de ce genre de notice avant d'autoriser la distribution de votre application. Pour plus d'informations, consultez le Guide de la vie privée.

## Installation

    cordova plugin add org.apache.cordova.media-capture
    

## Plates-formes prises en charge

*   Amazon Fire OS
*   Android
*   BlackBerry 10
*   iOS
*   Windows Phone 7 et 8
*   Windows 8

## Objets

*   Capture
*   CaptureAudioOptions
*   CaptureImageOptions
*   CaptureVideoOptions
*   CaptureCallback
*   CaptureErrorCB
*   ConfigurationData
*   MediaFile
*   MediaFileData

## Méthodes

*   capture.captureAudio
*   capture.captureImage
*   capture.captureVideo
*   MediaFile.getFormatData

## Propriétés

*   **supportedAudioModes** : les formats d'enregistrement audio supportés par l'appareil. (ConfigurationData[])

*   **supportedImageModes** : les formats et tailles de capture d'image supportés par l'appareil. (ConfigurationData[])

*   **supportedVideoModes**: les formats et résolutions d'enregistrement vidéo supportés par l'appareil. (ConfigurationData[])

## capture.captureAudio

> Ouvre l'application enregistreur audio et fournit des informations sur les fichiers audio capturés.

    navigator.device.capture.captureAudio(
        CaptureCB captureSuccess, CaptureErrorCB captureError,  [CaptureAudioOptions options]
    );
    

### Description

Débute une opération asynchrone de capture audio via l'application d'enregistrement audio par défaut de l'appareil. Cette opération permet à l'utilisateur de l'appareil d'enregistrer plusieurs prises en une seule séance de capture.

L'opération de capture se termine lorsque l'utilisateur quitte l'application d'enregistrement audio, ou quand le nombre maximal d'enregistrements spécifié par `CaptureAudioOptions.limit` est atteint. Si aucune valeur n'est fournie pour le paramètre `limit` celle utilisée par défaut est un (1), l'opération de capture se terminerait donc après que l'utilisateur ait enregistré un seul clip audio.

Une fois l'opération de capture terminée, la fonction callback `CaptureCallback` est exécutée et un tableau contenant des objets `MediaFile` décrivant chaque clip audio capturé lui est passé en paramètre. Si l'utilisateur annule l'opération avant qu'un clip audio ne soit capturé, la fonction callback `CaptureErrorCallback` est exécutée et un objet `CaptureError` comprenant le code d'erreur `CaptureError.CAPTURE_NO_MEDIA_FILES` lui est passé en paramètre.

### Plates-formes prises en charge

*   Amazon Fire OS
*   Android
*   BlackBerry 10
*   iOS
*   Windows Phone 7 et 8
*   Windows 8

### Exemple

    // fonction callback de capture
    var captureSuccess = function(mediaFiles) {
        var i, path, len;
        for (i = 0, len = mediaFiles.length; i < len; i += 1) {
            path = mediaFiles[i].fullPath;
            // faire quelque chose d'intéressant avec le fichier
        }
    };
    
    // fonction callback d'erreur de capture
    var captureError = function(error) {
        navigator.notification.alert('Code d\'erreur : ' + error.code, null, 'Erreur de capture');
    };
    
    // débute la capture audio
    navigator.device.capture.captureAudio(captureSuccess, captureError, {limit:2});
    

### BlackBerry 10 Quirks

*   Cordova pour BlackBerry 10 essaie de lancer l'application **Dictaphone Notes** , fournie par RIM, pour capturer des enregistrements audio. Le code d'erreur `CaptureError.CAPTURE_NOT_SUPPORTED` est renvoyé si celle-ci n'est pas installée sur l'appareil.

### iOS Quirks

*   iOS ne possède pas d'application d'enregistrement audio par défaut, par conséquent une interface utilisateur simple est fournie.

### Windows Phone 7 et 8 Quirks

*   Windows Phone 7 ne possède pas d'application d'enregistrement audio par défaut, par conséquent une interface utilisateur simple est fournie.

## CaptureAudioOptions

> Encapsule les options de configuration de capture audio.

### Propriétés

*   **limit** : le nombre maximal de clips audio que l'utilisateur peut enregistrer en une opération unique de capture. La valeur doit être supérieure ou égale à 1 (1 par défaut).

*   **duration** : la durée maximale d'un clip audio, en secondes.

### Exemple

    // limite l'operation de capture à 3 fichiers dont la durée ne dépasse pas 10 secondes chaque
    var options = { limit: 3, duration: 10 };
    
    navigator.device.capture.captureAudio(captureSuccess, captureError, options);
    

### Amazon Fire OS Quirks

*   Le `duration` paramètre n'est pas pris en charge. Longueurs d'enregistrement ne peut être limitée par programme.

### Quirks Android

*   Le `duration` paramètre n'est pas pris en charge. Longueurs d'enregistrement ne peut être limitée par programme.

### BlackBerry 10 Quirks

*   Le `duration` paramètre n'est pas pris en charge. Longueurs d'enregistrement ne peut être limitée par programme.

### iOS Quirks

*   Le paramètre `limit` n'est pas pris en charge, par conséquent un seul fichier audio peut être enregistré pour chaque appel.

## capture.captureImage

> Ouvre l'application appareil photo et fournit des informations sur les fichiers image capturés.

    navigator.device.capture.captureImage(
        CaptureCB captureSuccess, CaptureErrorCB captureError, [CaptureImageOptions options]
    );
    

### Description

Débute une opération asynchrone de capture d'images via l'application appareil photo par défaut de l'appareil. Cette opération permet à l'utilisateur de l'appareil d'enregistrer plusieurs prises en une seule séance de capture.

L'opération de capture soit termine lorsque l'utilisateur ferme l'application appareil photo, ou le nombre maximal d'enregistrements spécifié par `CaptureAudioOptions.limit` est atteinte. Si aucune valeur n'est fournie pour le paramètre `limit` celle utilisée par défaut est un (1), l'opération de capture se terminerait donc après que l'utilisateur ait enregistré une seule image.

Une fois l'opération de capture terminée, la fonction callback `CaptureCB` est exécutée et un tableau contenant des objets `MediaFile` décrivant chaque image capturée lui est passé en paramètre. Si l'utilisateur annule l'opération avant qu'une image ne soit capturée, la fonction callback `CaptureErrorCB` est exécutée et un objet `CaptureError` comprenant le code d'erreur `CaptureError.CAPTURE_NO_MEDIA_FILES` lui est passé en paramètre.

### Plates-formes prises en charge

*   Amazon Fire OS
*   Android
*   BlackBerry 10
*   iOS
*   Windows Phone 7 et 8
*   Windows 8

### Windows Phone 7 Quirks

Ouvrir l'application native appareil photo pendant que l'appareil est connecté via Zune ne fonctionne pas, la fonction callback d'erreur est exécutée dans ce cas.

### Exemple

    // fonction callback de capture
    var captureSuccess = function(mediaFiles) {
        var i, path, len;
        for (i = 0, len = mediaFiles.length; i < len; i += 1) {
            path = mediaFiles[i].fullPath;
            // faire quelque chose d'intéressant avec le fichier
        }
    };
    
    // fonction callback d'erreur de capture
    var captureError = function(error) {
        navigator.notification.alert('Code d\'erreur : ' + error.code, null, 'Erreur de capture');
    };
    
    // débute la capture d'image(s)
    navigator.device.capture.captureImage(captureSuccess, captureError, {limit:2});
    

## CaptureImageOptions

> Encapsule les options de configuration de capture d'image.

### Propriétés

*   **limit** : le nombre maximum d'images que l'utilisateur peut enregistrer en une opération unique de capture. La valeur doit être supérieure ou égale à 1 (1 par défaut).

### Exemple

    // limite l'opération de capture à 3 images
    var options = { limit: 3 };
    
    navigator.device.capture.captureImage(captureSuccess, captureError, options);
    

### iOS Quirks

*   Le paramètre **limit** n'est pas pris en charge, par conséquent une seule image est capturée par appel.

## capture.captureVideo

> Ouvre l'application enregistreur vidéo et fournit des informations sur les clips vidéo capturés.

    navigator.device.capture.captureVideo(
        CaptureCB captureSuccess, CaptureErrorCB captureError, [CaptureVideoOptions options]
    );
    

### Description

Débute une opération asynchrone de capture de vidéos via l'application d'enregistrement de vidéos par défaut de l'appareil. Cette opération permet à l'utilisateur de l'appareil d'enregistrer plusieurs fichiers en une seule séance de capture.

L'opération de capture se termine lorsque l'utilisateur quitte l'application d'enregistrement de vidéos, ou quand le nombre maximal d'enregistrements spécifié par `CaptureVideoOptions.limit` est atteint. Si aucune valeur n'est fournie pour le paramètre `limit` celle utilisée par défaut est un (1), l'opération de capture se terminerait donc après que l'utilisateur ait enregistré un seul clip vidéo.

Une fois l'opération de capture terminée, la fonction callback `CaptureCB` est exécutée et un tableau contenant des objets `MediaFile` décrivant chaque clip vidéo capturé lui est passé en paramètre. Si l'utilisateur annule l'opération avant qu'un clip vidéo ne soit capturé, la fonction callback `CaptureErrorCB` est exécutée et un objet `CaptureError` comprenant le code d'erreur `CaptureError.CAPTURE_NO_MEDIA_FILES` lui est passé en paramètre.

### Plates-formes prises en charge

*   Amazon Fire OS
*   Android
*   BlackBerry 10
*   iOS
*   Windows Phone 7 et 8
*   Windows 8

### Exemple

    // fonction callback de capture
    var captureSuccess = function(mediaFiles) {
        var i, path, len;
        for (i = 0, len = mediaFiles.length; i < len; i += 1) {
            path = mediaFiles[i].fullPath;
            // faire quelque chose d'intéressant avec le fichier
        }
    };
    
    // fonction callback d'erreur de capture
    var captureError = function(error) {
        navigator.notification.alert('Code d\'erreur : ' + error.code, null, 'Erreur de capture');
    };
    
    // débute la capture de vidéo(s)
    navigator.device.capture.captureVideo(captureSuccess, captureError, {limit:2});
    

### BlackBerry 10 Quirks

*   Cordova pour BlackBerry 10 essaie de lancer l'application **Enregistreur vidéo** , fournie par RIM, pour capturer les enregistrements vidéo. L'application reçoit un `CaptureError.CAPTURE_NOT_SUPPORTED` code d'erreur si l'application n'est pas installée sur l'appareil.

## CaptureVideoOptions

> Encapsule les options de configuration de capture vidéo.

### Propriétés

*   **limit** : le nombre maximal de clips vidéo que utilisateur peut enregistrer en une opération unique de capture. La valeur doit être supérieure ou égale à 1 (1 par défaut).

*   **duration** : la durée maximale d'un clip vidéo, en secondes.

### Exemple

    // limite l'opération de capture à 3 clips vidéo
    var options = { limit: 3 };
    
    navigator.device.capture.captureVideo(captureSuccess, captureError, options);
    

### BlackBerry 10 Quirks

*   Le paramètre de **durée** n'est pas supporté, donc la longueur des enregistrements ne peut pas être limitée par programme.

### iOS Quirks

*   Le paramètre **limit** n'est pas pris en charge. De ce fait, une seule vidéo est enregistrée par appel.

## CaptureCB

> Fonction appelée lors d'une opération de capture de médias réussie.

    function captureSuccess( MediaFile[] mediaFiles ) { ... };
    

### Description

Cette fonction est exécutée après qu'une opération de capture ait été menée à terme avec succès. À ce stade, un fichier média a été capturé et l'utilisateur a quitté l'application de capture ou bien la limite de capture a été atteinte.

Chaque objet `MediaFile` décrit un fichier média capturé.

### Exemple

    // fonction callback de capture
    function captureSuccess(mediaFiles) {
        var i, path, len;
        for (i = 0, len = mediaFiles.length; i < len; i += 1) {
            path = mediaFiles[i].fullPath;
            // faire quelque chose d'intéressant avec le fichier
        }
    };
    

## CaptureError

> Encapsule le code d'erreur résultant d'une opération de capture de médias ayant échoué.

### Propriétés

*   **code** : un des codes d'erreur prédéfinis énumérés ci-dessous.

### Constantes

*   `CaptureError.CAPTURE_INTERNAL_ERR` : la caméra ou le microphone n'a pas pu capturer d'image ou de son.

*   `CaptureError.CAPTURE_APPLICATION_BUSY` : l'application de capture vidéo ou audio est actuellement occupée à traiter une autre requête.

*   `CaptureError.CAPTURE_INVALID_ARGUMENT` : utilisation incorrecte de l'API (par exemple, la valeur donnée pour `limit` est inférieure à 1).

*   `CaptureError.CAPTURE_NO_MEDIA_FILES` : l'utilisateur a quitté l'application de capture audio ou vidéo avant de capturer quoi que ce soit.

*   `CaptureError.CAPTURE_NOT_SUPPORTED` : l'opération de capture demandée n'est pas prise en charge.

## CaptureErrorCB

> Fonction callback appelée si une erreur se produit pendant une opération de capture de médias.

    function captureError( CaptureError error ) { ... };
    

### Description

Cette fonction est exécutée si une erreur se produit lors d'une tentative de lancement d'une opération de capture de médias. Une telle erreur peut survenir lorsque l'application de capture est occupée, quand une opération de capture est déjà en cours, ou encore si l'utilisateur annule l'opération avant qu'un fichier média ait pu être capturé.

Un objet `CaptureError` contenant un `code` d'erreur approprié est transmis à cette fonction callback lors de son exécution.

### Exemple

    // fonction callback d'erreur de capture
    var captureError = function(error) {
        navigator.notification.alert('Code d\'erreur : ' + error.code, null, 'Erreur de capture');
    };
    

## ConfigurationData

> Encapsule un ensemble de paramètres de capture de médias pris en charge par un appareil.

### Description

Décrit les modes de capture de média pris en charge par l'appareil. Les données de configuration incluent le type MIME et les dimensions pour la capture de vidéo ou d'image.

Les types MIME doivent respecter la norme [RFC2046][1]. Exemples :

 [1]: http://www.ietf.org/rfc/rfc2046.txt

*   `video/3gpp`
*   `video/quicktime`
*   `image/jpeg`
*   `audio/amr`
*   `audio/wav`

### Propriétés

*   **type** : la chaîne de caractères bas de casse ASCII représentant le type de média souhaité. (DOMString)

*   **height** : la hauteur de l'image ou de la vidéo en pixels. La valeur pour les extraits sonores est zéro. (Number)

*   **width** : la largeur de l'image ou de la vidéo en pixels. La valeur pour les extraits sonores est zéro. (Number)

### Exemple

    // récupère des informations sur les modes de capture d'image supportés
    var imageModes = navigator.device.capture.supportedImageModes;
    
    // choisit le mode possédant la résolution horizontale la plus élevée
    var width = 0;
    var selectedmode;
    for each (var mode in imageModes) {
        if (mode.width > width) {
            width = mode.width;
            selectedmode = mode;
        }
    }
    

N'est pas pris en charge par toutes les plates-formes. Tous les tableaux de données de configuration sont vides.

## MediaFile.getFormatData

> Récupère des informations sur le format du fichier média capturé.

    mediaFile.getFormatData (MediaFileDataSuccessCB successCallback, [MediaFileDataErrorCB errorCallback]) ;
    

### Description

Cette fonction tente de récupérer les informations de format d'un fichier média de façon asynchrone. Si la tentative réussit, la fonction callback `MediaFileDataSuccessCB` est exécutée et un objet `MediaFileData` lui est transmis en paramètre. Si la tentative échoue, la fonction callback `MediaFileDataErrorCB` est appelée.

### Plates-formes prises en charge

*   Amazon Fire OS
*   Android
*   BlackBerry 10
*   iOS
*   Windows Phone 7 et 8
*   Windows 8

### Amazon Fire OS Quirks

L'API pour accéder aux informations de format des fichiers média est limitée, toutes les propriétés `MediaFileData` ne sont donc pas prises en charge.

### BlackBerry 10 Quirks

Aucune API permettant la récupération d'informations sur des fichiers média n'est disponible. Par conséquent, les objets `MediaFileData` contiennent toujours des valeurs par défaut.

### Quirks Android

L'API pour accéder aux médias file format informations est limité, donc pas tous les `MediaFileData` propriétés sont prises en charge.

### iOS Quirks

L'API pour accéder aux médias file format informations est limité, donc pas tous les `MediaFileData` propriétés sont prises en charge.

## MediaFile

> Encapsule les propriétés d'un fichier média capturé.

### Propriétés

*   **name** : le nom du fichier, sans le chemin d'accès associé. (DOMString)

*   **fullPath** : le chemin d'accès complet au fichier, nom compris. (DOMString)

*   **type** : le type MIME du fichier. (DOMString)

*   **lastModifiedDate** : la date et l'heure de la dernière modification du fichier. (Date)

*   **size** : le poids du fichier, en octets. (Number)

### Méthodes

*   **MediaFile.getFormatData** : récupère les informations de format du fichier média.

## MediaFileData

> Encapsule des informations de format d'un fichier média.

### Propriétés

*   **codecs** : le format réel du contenu audio et vidéo. (DOMString)

*   **bitrate** : le débit moyen du contenu. Pour les images, la valeur est zéro. (Number)

*   **height** : la hauteur de l'image ou de la vidéo en pixels. Pour des clips audio, la valeur est zéro. (Number)

*   **width** : la largeur de l'image ou de la vidéo en pixels. Pour des clips audio, la valeur est zéro. (Number)

*   **duration** : la durée du clip vidéo ou audio en secondes. Pour les images, la valeur est zéro. (Number)

### BlackBerry 10 Quirks

Aucune API fournissant des informations sur le format des fichiers média n'est disponible, par conséquent les objets `MediaFileData` retournés par `MediaFile.getFormatData` comportent les valeurs par défaut suivantes :

*   **codecs** : propriété non prise en charge, sa valeur est `null`.

*   **bitrate** : propriété non prise en charge, sa valeur est zéro.

*   **height** : propriété non prise en charge, sa valeur est zéro.

*   **width** : propriété non prise en charge, sa valeur est zéro.

*   **duration** : propriété non prise en charge, sa valeur est zéro.

### Amazon Fire OS Quirks

Supporte les propriétés `MediaFileData` suivantes :

*   **codecs**: pas pris en charge et retourne`null`.

*   **Bitrate**: pas pris en charge et retourne la valeur zéro.

*   **height** : propriété prise en charge seulement pour les fichiers image et vidéo.

*   **width** : propriété prise en charge seulement pour les fichiers image et vidéo.

*   **durée**: prise en charge : seuls les fichiers audio et vidéo

### Quirks Android

Prend en charge ce qui suit `MediaFileData` Propriétés :

*   **codecs**: pas pris en charge et retourne`null`.

*   **Bitrate**: pas pris en charge et retourne la valeur zéro.

*   **hauteur**: prise en charge : seuls les fichiers image et vidéo.

*   **largeur**: prise en charge : seuls les fichiers image et vidéo.

*   **duration** : propriété prise en charge seulement pour les fichiers audio et vidéo.

### iOS Quirks

Prend en charge ce qui suit `MediaFileData` Propriétés :

*   **codecs**: pas pris en charge et retourne`null`.

*   **bitrate** : propriété prise en charge uniquement pour les fichiers audio sous iOS4. Renvoie zéro pour les images et les vidéos.

*   **hauteur**: prise en charge : seuls les fichiers image et vidéo.

*   **largeur**: prise en charge : seuls les fichiers image et vidéo.

*   **durée**: prise en charge : seuls les fichiers audio et vidéo.