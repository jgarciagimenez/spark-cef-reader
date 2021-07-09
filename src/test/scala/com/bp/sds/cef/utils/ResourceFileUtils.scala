package com.bp.sds.cef.utils

import java.net.{URI, URLDecoder}
import scala.io.{BufferedSource, Source}

object ResourceFileUtils {
  def getFileContent(relativePath: String): String = {
    val scriptSourcePath = getClass.getResource(relativePath).getPath
    var scriptSource: BufferedSource = null

    try {
      scriptSource = Source.fromFile(scriptSourcePath)
      scriptSource.getLines().mkString("\n")
    } finally {
      if (scriptSource != null) scriptSource.close()
    }
  }

  def getFilePath(relativePath: String): String = {
    val path = getClass.getResource(relativePath).getPath
    URLDecoder.decode(path, "utf8")
  }

  def getResourceRoot: URI = {
    getClass.getResource("/").toURI
  }
}