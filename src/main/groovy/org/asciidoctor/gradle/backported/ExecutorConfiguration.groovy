/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.asciidoctor.gradle.backported

import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import java.util.regex.Pattern

/** Configuration for running Asciidoctor
 *
 * @since 1.5.9 (Backported from 2.0)
 * @author Schalk W. Cronjé
 */
@CompileStatic
@SuppressWarnings(['ClassName','CloneableWithoutClone'])
@TupleConstructor
class ExecutorConfiguration implements Serializable, Cloneable {
    File sourceDir
    File outputDir
    File projectDir
    File rootDir
    File baseDir
    Set<File> sourceTree
    List<Pattern> fatalMessagePatterns

    String backendName
    String gemPath

    boolean logDocuments
    boolean copyResources

    int safeModeLevel

    Set<String> requires
    Map<String, Object> options
    Map<String, Object> attributes

    List<Object> asciidoctorExtensions

//    ExecutorLogLevel executorLogLevel

    String toString() {
        """backend(s) = ${backendName}

File locations:
  sourceDir = ${sourceDir}
  outputDir = ${outputDir}
  projectDir = ${projectDir}
  rootProjectDir = ${rootDir}
  baseDir = ${baseDir}

JRuby:
  GEMPATH = ${gemPath}
  requires = ${requires}

Asciidoctor:
  ${options.size()} options
  ${attributes.size()} attributes
  ${asciidoctorExtensions?.size() ?: 0} extensions
  logDocuments = ${logDocuments}, copyReources = ${copyResources}, safeMode = ${safeModeLevel}
"""
    }
}

