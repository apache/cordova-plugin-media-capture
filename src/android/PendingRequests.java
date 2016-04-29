/*
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
*/

package org.apache.cordova.mediacapture;

import android.util.SparseArray;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Holds the pending javascript requests for the plugin
 */
public class PendingRequests {
    private int currentReqId = 0;
    private SparseArray<Request> requests = new SparseArray<Request>();

    /**
     * Creates a request and adds it to the array of pending requests. Each created request gets a
     * unique result code for use with startActivityForResult() and requestPermission()
     * @param action            The action this request corresponds to (capture image, capture audio, etc.)
     * @param options           The options for this request passed from the javascript
     * @param callbackContext   The CallbackContext to return the result to
     * @return                  The newly created Request object with a unique result code
     * @throws JSONException
     */
    public synchronized Request createRequest(int action, JSONObject options, CallbackContext callbackContext) throws JSONException {
        Request req = new Request(action, options, callbackContext);
        requests.put(req.requestCode, req);
        return req;
    }

    /**
     * Gets the request corresponding to this request code
     * @param requestCode   The request code for the desired request
     * @return              The request corresponding to the given request code or null if such a
     *                      request is not found
     */
    public synchronized Request get(int requestCode) {
        return requests.get(requestCode);
    }

    /**
     * Removes the request from the array of pending requests and sends an error plugin result
     * to the CallbackContext that contains the given error object
     * @param req   The request to be resolved
     * @param error The error to be returned to the CallbackContext
     */
    public synchronized void resolveWithFailure(Request req, JSONObject error) {
        req.callbackContext.error(error);
        requests.remove(req.requestCode);
    }

    /**
     * Removes the request from the array of pending requests and sends a successful plugin result
     * to the CallbackContext that contains the result of the request
     * @param req   The request to be resolved
     */
    public synchronized void resolveWithSuccess(Request req) {
        req.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, req.results));
        requests.remove(req.requestCode);
    }


    /**
     * Each request gets a unique ID that represents its request code when calls are made to
     * Activities and for permission requests
     * @return  A unique request code
     */
    private synchronized int incrementCurrentReqId() {
        return currentReqId ++;
    }

    /**
     * Holds the options and CallbackContext for a capture request made to the plugin.
     */
    public class Request {

        // Unique int used to identify this request in any Android Permission or Activity callbacks
        public int requestCode;

        // The action that this request is performing
        public int action;

        // The number of pics/vids/audio clips to take (CAPTURE_IMAGE, CAPTURE_VIDEO, CAPTURE_AUDIO)
        public long limit = 1;

        // Optional max duration of recording in seconds (CAPTURE_VIDEO only)
        public int duration = 0;

        // Quality level for video capture 0 low, 1 high (CAPTURE_VIDEO only)
        public int quality = 1;

        // The array of results to be returned to the javascript callback on success
        public JSONArray results = new JSONArray();

        // The callback context for this plugin request
        private CallbackContext callbackContext;

        private Request(int action, JSONObject options, CallbackContext callbackContext) throws JSONException {
            this.callbackContext = callbackContext;
            this.action = action;

            if (options != null) {
                this.limit = options.optLong("limit", 1);
                this.duration = options.optInt("duration", 0);
                this.quality = options.optInt("quality", 1);
            }

            this.requestCode = incrementCurrentReqId();
        }
    }
}
