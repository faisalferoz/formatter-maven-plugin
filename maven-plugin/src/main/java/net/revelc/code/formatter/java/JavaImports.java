/**
 * Copyright 2010-2017. All work is copyrighted to their respective
 * author(s), unless otherwise stated.
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
package net.revelc.code.formatter.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class JavaImports extends TreeSet<String> {

    public JavaImports() {
        //
        super(new Comparator<String>() {
            @Override
            public int compare(String lineImport1, String lineImport2) {
                //
                return lineImport1.compareTo(lineImport2);
            }
        });
    }

    public List<String> toLines() {
        String group = null;
        //
        List<String> lineImports = new ArrayList<String>();
        for (String lineImport : this) {
            String currentGroup = lineImport.substring("import ".length(), lineImport.indexOf("."));
            if (!currentGroup.equals(group)) {
                group = currentGroup;
                lineImports.add("\n");
            }
            lineImports.add(lineImport);
            lineImports.add("\n");
        }
        //
        return lineImports;
    }

    @Override
    public String toString() {
        //
        StringBuilder stringBuilder = new StringBuilder();
        for (String lineImport : toLines()) {
            stringBuilder.append(lineImport);
        }
        //
        return stringBuilder.toString();
    }

}