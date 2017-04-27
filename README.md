# BannerButton

## 中文说明

该项目是为了更简便的实现在viewpager中动态加载item，仅使用一个list就可以动态的去判断是否需要翻页。所以这个框架可以通过后台发送过来的数据来在手机上根据不同的用户，或者权限来显示不同的item，甚至可以动态的加载行列数。而非其他框架使用布局，将控件写死只能用来加载固定的布局。

### 结构介绍

    <div class='row'>
        <img src='https://github.com/liyuhaolol/BannerButton/blob/master/pic/01.jpg' width="487px"/>
    </div>

在viewpager底部放置一个linearlayout，用来加载页签指示器。

viewpager里嵌套一个gradview，使用gridview来动态的加载item

![Github](https://github.com/liyuhaolol/BannerButton/blob/master/pic/02.jpg)

## English

The project is to achieve a more simple way to dynamic loading item in the view pager,using only a list can dynamically determine whether have many pages.

So this framework can be sent through the server to the phone according to different users,or permissions to show different item, even the lines and columns can be dynamic load.

Instead of using the layout of the other framework, the control to write dead can only be used to load the fixed layout.

### structure

![Github](https://github.com/liyuhaolol/BannerButton/blob/master/pic/01.jpg)

viewpager bottom put a linearlayout, for load the indicator

viewpager nest a gradview，use gridview dynamic loading item
