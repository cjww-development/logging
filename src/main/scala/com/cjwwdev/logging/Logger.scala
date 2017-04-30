// Copyright (C) 2016-2017 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.cjwwdev.logging

import org.joda.time.DateTime
import play.api.{Logger => PlayLogger}

object Logger extends Logger

trait Logger {
  private def getNow: String = {
    DateTime.now.toString("dd/MM/yyyy HH:mm:ss")
  }

  def info(message: String): Unit = {
    if(PlayLogger.isInfoEnabled) {
      PlayLogger.info(s"[$getNow] - $message")
    }
  }

  def info(message: String, error: Throwable) : Unit = {
    if(PlayLogger.isInfoEnabled) {
      PlayLogger.info(s"[$getNow] - $message")
      error.printStackTrace()
    }
  }

  def warn(message : String) : Unit = {
    if(PlayLogger.isWarnEnabled) {
      PlayLogger.warn(s"[$getNow] - $message")
    }
  }

  def warn(message : String, error : Throwable) : Unit = {
    if(PlayLogger.isWarnEnabled) {
      PlayLogger.warn(s"[$getNow] - $message")
      error.printStackTrace()
    }
  }

  def error(message : String) : Unit = {
    if(PlayLogger.isErrorEnabled) {
      PlayLogger.error(s"[$getNow] - $message")
    }
  }

  def error(message : String, error : Throwable) : Unit = {
    if(PlayLogger.isErrorEnabled) {
      PlayLogger.error(s"[$getNow] - $message")
      error.printStackTrace()
    }
  }
}
