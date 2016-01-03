###WEB语义化

@(Jβearmen)[前端, 规范, 标准]

**语义化**是让机器更加容易理解WEB里面的内容，这里的机器可以是爬虫软件、搜索引擎、浏览器以及读屏软件，本文章主要整理一下WEB语义化的一些内容。
 


-------------------

####HTML标签语义化

“用合理HTML标记以及其特有的属性去格式化文档内容”——这是舒克对语义化标签的解释，能不用&lt;div>的地方不用&lt;div>，因为&lt;div>是无语义的标签，原本单词是division，为分隔、区块的意思，一般只用在架构html的地方，在(x)html以前的版本。
<table>
<tbody>
<tr>
<th scope="col" width="66">标签</th>
<th scope="col" width="128">原单词</th>
<th scope="col" width="220">说明</th>
<th scope="col" width="119">语义化(Y/N)</th>
</tr>
<tr>
<td>h1-h6</td>
<td>head</td>
<td>定义 HTML 标题</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>p</td>
<td>paragraph</td>
<td>定义段落</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>ul</td>
<td>unordered list</td>
<td>定义无序列表</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>ol</td>
<td>ordered list</td>
<td>定义有序列表</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>li</td>
<td>list item</td>
<td>定义列表的项目</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>dl</td>
<td>definition list</td>
<td>定义定义列表</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>dt</td>
<td>definition term</td>
<td>定义定义列表中的项目</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>dd</td>
<td>definition description</td>
<td>定义定义列表中项目的描述</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>table</td>
<td>table</td>
<td>定义表格</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>thead</td>
<td>table head</td>
<td>定义表格中的表头内容</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>tbody</td>
<td>table body</td>
<td>定义表格中的主体内容</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>th</td>
<td>table head cell</td>
<td>定义表格中的表头单元格</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>tr</td>
<td>table row</td>
<td>定义表格中的行</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>td</td>
<td>table data cell</td>
<td>定义表格中的单元</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>a</td>
<td>anchor</td>
<td>定义锚</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>img</td>
<td>image</td>
<td>定义图像</td>
<td>&nbsp;Y</td>
</tr>
<tr>
<td>div</td>
<td>division</td>
<td>定义文档中的节</td>
<td>&nbsp;N</td>
</tr>
<tr>
<td>span</td>
<td>span</td>
<td>定义文档中的节</td>
<td>&nbsp;N</td>
</tr>
</tbody>
</table>

以上只是列出了我们常用的一些标签，更多的标签请查阅[w3c](http://www.w3school.com.cn/tags/html_ref_byfunc.asp) ，基本所有的html标签都是一个单词或者词组的缩写，这样其实本意是更便于我们对语义化的理解。其实所有的(x)html标签中，除了&lt;div>和&lt;span>2个无语义的标签，其他标签都有它存在的意义，只有知道有哪些标签，以及对各个标签的本义做一个了解才能知道去用它。你不知道何时用&lt;dl>定义列表标签？又如果你不知道有&lt;sup>标签？


####CSS命名语义化

CSS语义化的命名是指用易于理解的名称对HTML标签附加的class或id命名。语义化的命名这里就涉及到了团队的命名规范，只有在团队的规范的基础之上进行更好的语义化命名才是王道。一个语义化的CSS命名至少应遵守如下约定：

**尽量规避拼音命名，用英文单词去命名**；
**单词之间连接用三种方式：下划线_  、间隔符-、驼峰命名**；
**单词后不要跟无意义的数字**；
**对于过长单词的连接命名可采取缩写形式**。

一些约定好的单词可以迅速的帮助大家命名：

<pre>头：header
内容：content/container
尾：footer
导航：nav
侧栏：sidebar
栏目：column
登录条：loginbar
标志：logo
广告：banner
轮转：promo
页面主体：main
热点：hot
新闻：news&nbsp;&nbsp;
下载：download
子导航：subnav
菜单：menu
子菜单：submenu
搜索：search&nbsp;&nbsp;&nbsp;&nbsp;
友情链接：friendlink
版权：copyright ......</pre>
