/*
 * 全局变量
 * 日期：2018年12月12日
 * 作者：zz   zhz@jszzkj.cn
 * */

const WEBURL = "jianhuzh";
const APIURL = "/jianhuzh";

function _parseAPIURL(apiName, relativePath) {
  if (!apiName) {
    return "[_parseAPIURL]需要第一个参数：api名称。";
  }

  return (relativePath || APIURL) + apiName;
}
