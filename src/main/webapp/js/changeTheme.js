/*获取主题名字*/
;
if(!localStorage.getItem('themeNumber')) {localStorage.setItem('themeNumber',0);}
var tcn = localStorage.getItem('themeNumber');

/*顶部背景色,顶部下边框颜色,
        左侧边栏背景颜色,左侧右边框颜色,
        折叠按钮下边框颜色,
        菜单背景颜色,二级菜单背景色,三级菜单背景色,菜单选中状态背景色,
        滚动条颜色,
        标签字体颜色,标签下滚动条颜色*/

function LingTheme(themeColor) {

  this.顶部背景色=themeColor.顶部背景色;
  this.顶部下边框颜色=themeColor.顶部下边框颜色;
  this.左侧边栏背景颜色=themeColor.左侧边栏背景颜色;
  this.左侧右边框颜色=themeColor.左侧右边框颜色;
  this.折叠按钮下边框颜色=themeColor.折叠按钮下边框颜色;
  this.菜单背景颜色=themeColor.菜单背景颜色;
  this.二级菜单背景色=themeColor.二级菜单背景色;
  this.三级菜单背景色=themeColor.三级菜单背景色;
  this.菜单选中状态背景色=themeColor.菜单选中状态背景色;
  this.滚动条颜色=themeColor.滚动条颜色;
  this.标签字体颜色=themeColor.标签字体颜色;
  this.标签下滚动条颜色=themeColor.标签下滚动条颜色;
}

function themeStyle(LingTheme) {
  var style = '/*0号 */\n' +
    '.header {background-color: '+LingTheme.顶部背景色+'!important;}\n' +
    '.header {border-bottom: 1px solid '+LingTheme.顶部下边框颜色+';}\n' +
    '.sidebar[class] {background-color: '+LingTheme.左侧边栏背景颜色+';}\n' +
    '.sidebar[class] {border-right: 1px solid '+LingTheme.左侧右边框颜色+';}\n' +
    '.fold{border-bottom: 1px solid '+LingTheme.折叠按钮下边框颜色+';}\n' +
    '.sidebar-menu ul{background-color: '+LingTheme.菜单背景颜色+';}\n' +
    '.layui-side .lau-nav-item .lau-nav-child {background-color: '+LingTheme.二级菜单背景色+';}\n' +
    '.layui-side .lau-nav-item .lau-nav-child dd .lau-nav-child {background-color: '+LingTheme.三级菜单背景色+';}\n' +
    '.sidebar .nav-select{background-color: '+LingTheme.菜单选中状态背景色+';}\n' +
    '.sidebar[class] .layui-nav-bar,.menu-user .layui-nav-bar{background-color: '+LingTheme.滚动条颜色+';}\n' +
    '.layui-tab-brief > .layui-tab-title .layui-this{color: '+LingTheme.标签字体颜色+';}\n' +
    '.layui-body .layui-tab-title li:after{border-color: '+LingTheme.标签下滚动条颜色+'!important;}';

  return style;
}

var themeColor1 = {
  顶部背景色:'#20222a',
  顶部下边框颜色:'#0c0d0f',
  左侧边栏背景颜色:'#20222a',
  左侧右边框颜色:'#2a2f32',
  折叠按钮下边框颜色:'#0c0d0f',
  菜单背景颜色:'#373940',
  二级菜单背景色:'#16181d',
  三级菜单背景色:'#0c0d0f',
  菜单选中状态背景色:'#009688',
  滚动条颜色:'rgba(255,255,255,.5)',
  标签字体颜色:'#009688',
  标签下滚动条颜色:'#009688'
};

var themeColor2 = {
  顶部背景色:'#03152a',
  顶部下边框颜色:'#020f1d',
  左侧边栏背景颜色:'#03152a',
  左侧右边框颜色:'#020f1d',
  折叠按钮下边框颜色:'#0c0d0f',
  菜单背景颜色:'#03152a',
  二级菜单背景色:'#020f1d',
  三级菜单背景色:'#010b14',
  菜单选中状态背景色:'#3b91ff',
  滚动条颜色:'rgba(255,255,255,.5)',
  标签字体颜色:'#124580',
  标签下滚动条颜色:'#124580'
};

var themeColor3 = {
  顶部背景色:'#50314f',
  顶部下边框颜色:'#472c46',
  左侧边栏背景颜色:'#50314f',
  左侧右边框颜色:'#472c46',
  折叠按钮下边框颜色:'#472c46',
  菜单背景颜色:'#50314f',
  二级菜单背景色:'#382237',
  三级菜单背景色:'#211420',
  菜单选中状态背景色:'#7a4d7b',
  滚动条颜色:'rgba(255,255,255,.5)',
  标签字体颜色:'#7a4d7b',
  标签下滚动条颜色:'#7a4d7b'
};

var themeColor4 = {
  顶部背景色:'#992c2b',
  顶部下边框颜色:'#992c2b',
  左侧边栏背景颜色:'#242e38',
  左侧右边框颜色:'#242e38',
  折叠按钮下边框颜色:'#242e38',
  菜单背景颜色:'#242e38',
  二级菜单背景色:'#192027',
  三级菜单背景色:'#10151a',
  菜单选中状态背景色:'#992c2b',
  滚动条颜色:'rgba(255,255,255,.5)',
  标签字体颜色:'#9e1f24',
  标签下滚动条颜色:'#9e1f24'
};

var themeColor5 = {
  顶部背景色:'#0078d1',
  顶部下边框颜色:'#0c0d0f',
  左侧边栏背景颜色:'#344058',
  左侧右边框颜色:'#2a2f32',
  折叠按钮下边框颜色:'#2a2f32',
  菜单背景颜色:'#344058',
  二级菜单背景色:'#2d384d',
  三级菜单背景色:'#242d3d',
  菜单选中状态背景色:'#0078d1',
  滚动条颜色:'rgba(255,255,255,.5)',
  标签字体颜色:'#344058',
  标签下滚动条颜色:'#344058'
};

var themeColor6 = {
  顶部背景色:'#009688',
  顶部下边框颜色:'#009688',
  左侧边栏背景颜色:'#009688',
  左侧右边框颜色:'#009688',
  折叠按钮下边框颜色:'#009688',
  菜单背景颜色:'#009688',
  二级菜单背景色:'#009688',
  三级菜单背景色:'#009688',
  菜单选中状态背景色:'#00635a',
  滚动条颜色:'rgba(255,255,255,.5)',
  标签字体颜色:'#009688',
  标签下滚动条颜色:'#009688'
};

//主题颜色数据
var themeDate = [
  '/*0号 默认*/\n' +
  '.header {background-color: #20222a;}\n' +
  '.header {border-bottom: 1px solid #0c0d0f;}\n' +
  '.sidebar[class] {background-color: #20222a;}\n' +
  '.sidebar[class] {border-right: 1px solid #2a2f32;}\n' +
  '.fold{border-bottom: 1px solid #0c0d0f;}\n' +
  '.sidebar-menu ul{background-color: #373940;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child {background-color: #16181d;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child dd .lau-nav-child {background-color: #0c0d0f;}\n' +
  '.sidebar .nav-select{background-color: #009688;}\n' +
  '.sidebar[class] .layui-nav-bar,.menu-user .layui-nav-bar{background-color: rgba(255,255,255,.5);}\n' +
  '.layui-tab-brief > .layui-tab-title .layui-this{color: #009688;}\n' +
  '.layui-body .layui-tab-title li:after{border-color: #009688!important;}'
  ,
  '/*1号 深蓝*/\n' +
  '.header {background-color: #03152a!important;}\n' +
  '.header {border-bottom: 1px solid #020f1d;}\n' +
  '.sidebar[class] {background-color: #03152a;}\n' +
  '.sidebar[class] {border-right: 1px solid #020f1d;}\n' +
  '.fold{border-bottom: 1px solid #020f1d;}\n' +
  '.sidebar-menu ul{background-color: #03152a;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child {background-color: #020f1d;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child dd .lau-nav-child {background-color: #010b14;}\n' +
  '.sidebar .nav-select{background-color: #3b91ff;}\n' +
  '.sidebar[class] .layui-nav-bar,.menu-user .layui-nav-bar{background-color: rgba(255,255,255,.5);}\n' +
  '.layui-tab-brief > .layui-tab-title .layui-this{color: #124580;}\n' +
  '.layui-body .layui-tab-title li:after{border-color: #124580!important;}'
  ,
  '/*2号 深紫*/\n' +
  '.header {background-color: #50314f!important;}\n' +
  '.header {border-bottom: 1px solid #472c46;}\n' +
  '.sidebar[class] {background-color: #50314f;}\n' +
  '.sidebar[class] {border-right: 1px solid #472c46;}\n' +
  '.fold{border-bottom: 1px solid #472c46;}\n' +
  '.sidebar-menu ul{background-color: #50314f;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child {background-color: #382237;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child dd .lau-nav-child {background-color: #211420;}\n' +
  '.sidebar .nav-select{background-color: #7a4d7b;}\n' +
  '.sidebar[class] .layui-nav-bar,.menu-user .layui-nav-bar{background-color: rgba(255,255,255,.5);}\n' +
  '.layui-tab-brief > .layui-tab-title .layui-this{color: #7a4d7b;}\n' +
  '.layui-body .layui-tab-title li:after{border-color: #7a4d7b!important;}'
  ,
  '/*3号 深红*/\n' +
  '.header {background-color: #992c2b!important;}\n' +
  '.header {border-bottom: 1px solid #992c2b;}\n' +
  '.sidebar[class] {background-color: #242e38;}\n' +
  '.sidebar[class] {border-right: 1px solid #242e38;}\n' +
  '.fold{border-bottom: 1px solid #242e38;}\n' +
  '.sidebar-menu ul{background-color: #242e38;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child {background-color: #192027;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child dd .lau-nav-child {background-color: #10151a;}\n' +
  '.sidebar .nav-select{background-color: #992c2b;}\n' +
  '.sidebar[class] .layui-nav-bar,.menu-user .layui-nav-bar{background-color: rgba(255,255,255,.5);}\n' +
  '.layui-tab-brief > .layui-tab-title .layui-this{color: #9e1f24;}\n' +
  '.layui-body .layui-tab-title li:after{border-color: #9e1f24!important;}'
  ,
  '/*4号 亮蓝*/\n' +
  '.header {background-color: #0078d1!important;}\n' +
  '.header {border-bottom: 1px solid #0c0d0f;}\n' +
  '.sidebar[class] {background-color: #344058;}\n' +
  '.sidebar[class] {border-right: 1px solid #2a2f32;}\n' +
  '.fold{border-bottom: 1px solid #2a2f32;}\n' +
  '.sidebar-menu ul{background-color: #344058;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child {background-color: #2d384d;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child dd .lau-nav-child {background-color: #242d3d;}\n' +
  '.sidebar .nav-select{background-color: #0078d1;}\n' +
  '.sidebar[class] .layui-nav-bar,.menu-user .layui-nav-bar{background-color: rgba(255,255,255,.5);}\n' +
  '.layui-tab-brief > .layui-tab-title .layui-this{color: #344058;}\n' +
  '.layui-body .layui-tab-title li:after{border-color: #344058!important;}'
  ,
  '/*5号 浅绿*/\n' +
  '.header {background-color: #009688!important;}\n' +
  '.header {border-bottom: 1px solid #009688;}\n' +
  '.sidebar[class] {background-color: #009688;}\n' +
  '.sidebar[class] {border-right: 1px solid #009688;}\n' +
  '.fold{border-bottom: 1px solid #009688;}\n' +
  '.sidebar-menu ul{background-color: #009688;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child {background-color: #009688;}\n' +
  '.layui-side .lau-nav-item .lau-nav-child dd .lau-nav-child {background-color: #009688;}\n' +
  '.sidebar .nav-select{background-color: #00635a;}\n' +
  '.sidebar[class] .layui-nav-bar,.menu-user .layui-nav-bar{background-color: rgba(255,255,255,.5);}\n' +
  '.layui-tab-brief > .layui-tab-title .layui-this{color: #344058;}\n' +
  '.layui-body .layui-tab-title li:after{border-color: #009688!important;}'
];
var themeName = ['默认','深蓝','深紫','深红','亮蓝','浅绿'];
var themeDate1 = [themeColor1,themeColor2,themeColor3,themeColor4,themeColor5,themeColor6];
//渲染CSS样式函数
function changeTheme(index){
  //$('#adminTheme').html(themeDate[index]);
  var Theme = new LingTheme(themeDate1[index]);
  $('#adminTheme').html(themeStyle(Theme));
}

//执行渲染
// changeTheme(tcn);

/*onclick事件
* 改变主题序号
* 运行渲染函数*/
// $("#changeTheme").click(function(){
//     tcn<themeDate1.length -1?tcn++:tcn=0;
//     changeTheme(tcn);
//     layer.msg('已切换配色 - ' + themeName[tcn]);
//     localStorage.setItem('themeNumber',tcn);
// });

