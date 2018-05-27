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
package serializer

import akka.util.ByteString
import com.lucidchart.open.xtract.XmlReader
import model.News

import scala.xml.{Elem, XML}

object XMLStringDeserializer {

/*

  implicit val byteStringFormatter: ByteStringFormatter[News] = new ByteStringFormatter[News] {

    val collectionOfNews: Set[News]

    def deserialize(bs: ByteString): Set[Option[News]] = {

      val listOfNews: List[String] = bs.utf8String.split("</news>").toList
      listOfNews.map{ elem =>
         val xml: Elem = XML.loadString(elem.concat("</news>"))
        XmlReader.of[News].read(xml).toOption
      }
    }.toSet

    def deserializeSet(): Unit ={

    }
  }
*/
}