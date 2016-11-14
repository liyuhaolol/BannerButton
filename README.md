# BannerButton
##中文说明
该项目是为了更简便的实现在viewpager中动态加载item，仅使用一个list就可以动态的去判断是否需要翻页。
所以这个框架可以通过后台发送过来的数据来在手机上根据不同的用户，或者权限来显示不同的item，甚至可以动态的加载行列数。
而非其他框架使用布局，将控件写死只能用来加载固定的布局。<br>
###结构介绍
![weibo](http://ww1.sinaimg.cn/mw690/4369f9c9jw1f9rms2ay36j20dj09umxb.jpg)  <br>
在viewpager底部放置一个linearlayout，用来加载页签指示器。<br>
viewpager里嵌套一个gradview，使用gridview来动态的加载item<br>
![weibo](http://ww3.sinaimg.cn/mw690/4369f9c9jw1f9rn2t0cc4j20u01hctfl.jpg)  <br>
##English
The project is to achieve a more simple way to dynamic loading item in the view pager, 
using only a list can dynamically determine whether have many pages.
So this framework can be sent through the server to the phone according to different users, 
or permissions to show different item, even the lines and columns can be dynamic load.
Instead of using the layout of the other framework, the control to write dead can only be used to load the fixed layout.<br>
###structure
![weibo](http://ww1.sinaimg.cn/mw690/4369f9c9jw1f9rms2ay36j20dj09umxb.jpg)  <br>
viewpager bottom put a linearlayout, for load the indicator<br>
viewpager nest a gradview，use gridview dynamic loading item<br>
