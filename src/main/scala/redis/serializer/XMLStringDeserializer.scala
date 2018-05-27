/*
 * Copyright 2016-2018 the original author or authors.
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
package redis.serializer

import com.lucidchart.open.xtract.XmlReader
import model.News
import scredis.serialization._

import scala.xml.{Elem, XML}

object XMLStringDeserializer {

  implicit object NewsReader extends Reader[News] {
    val utf8StringReader = new StringReader("UTF-8")

    override def readImpl(bytes: Array[Byte]): News = {
      val news: String = utf8StringReader.read(bytes)
      val xml: Elem = XML.loadString(news)
      val objectNews: Option[News] = XmlReader.of[News].read(xml).toOption
      objectNews.getOrElse(News("error", "error"))
    }
  }

}