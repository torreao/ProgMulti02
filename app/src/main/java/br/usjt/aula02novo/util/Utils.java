/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.usjt.aula02novo.util;

import android.os.Handler;
import android.widget.TextView;

import java.util.List;

public class Utils {

    private static br.usjt.aula02novo.util.StatusTracker mStatusTracker = br.usjt.aula02novo.util.StatusTracker.getInstance();

    /**
     * Marcelo Torreão 816113657 SI3AN-MCA Programação Multiplataforma e Paradigmas de Linguagem
     */

    public static void printStatus(final TextView viewMethods, final TextView viewStatus) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Get the stack of Activity lifecycle methods called and print to TextView
                StringBuilder sbMethods = new StringBuilder();
                List<String> listMethods = mStatusTracker.getMethodList();
                for (String method : listMethods) {
                    sbMethods.insert(0, method + "\r\n");
                }
                if(viewMethods != null) {
                    viewMethods.setText(sbMethods.toString());
                }

                // Get the status of all Activity classes and print to TextView
                StringBuilder sbStatus = new StringBuilder();
                for (String key : mStatusTracker.keySet()) {
                    sbStatus.insert(0,key + ": " + mStatusTracker.getStatus(key) + "\n");
                }
                if(viewStatus != null) {
                    viewStatus.setText(sbStatus.toString());
                }
            }
        }, 750);
    }
}




