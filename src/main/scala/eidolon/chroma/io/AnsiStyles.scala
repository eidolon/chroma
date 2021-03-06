/**
 * This file is part of the "chroma" project.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the LICENSE is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package eidolon.chroma.io

/**
 * AnsiStyles
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
trait AnsiStyles {
    /**
     * Get a style by it's name
     *
     * @param name Name of style
     * @return The style
     */
    def getStyle(name: String): AnsiStyle
}
