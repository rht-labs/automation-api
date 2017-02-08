/*
 * Copyright (C) 2016 Original Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rhc.automation.jenkinsfile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GeneratorConstants {
    public static final Set<String> SUPPORTED_BUILD_TOOLS = new HashSet<String>( Arrays.asList( "node-0.10", "node-4", "mvn-3", "sh", "s2i" ) );
}
