<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>12306选择城市</title>
<link href="./js/station.css" rel="stylesheet" type="text/css">
<script src="./js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="./js/station_name.js" type="text/javascript"></script>
<script src="./js/favorite_name.js" type="text/javascript"></script>
<script src="./js/city_name.js" type="text/javascript"></script>
</head>
<body>
<div style="top:0;left:0;z-index:1000;POSITION: absolute;">
  <div style="overflow: hidden; left: 323px; top: 90.5px; display: none;" id="form_cities">
    <div id="top_cities">简码/汉字或↑↓</div>
    <div id="panel_cities"></div>
    <div style="display: block;" id="flip_cities">
			«&nbsp;向前&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="" class="cityflip" onclick="city_showlist(1);return false;">向后&nbsp;»</a>
	</div>
  </div>
</div>

<div style="top:0;left:0;z-index:1000;POSITION: absolute;">
  <div style="overflow: hidden; display: none; left: 323px; top: 90.5px;" id="form_cities2">
    <div id="top_cities1"> </div>
    <div id="panel_cities2"></div>
  </div>
</div>
<table class="cx_from" border="0" cellpadding="0" cellspacing="0" width="600">
  <tbody>
	<tr>
	  <td class="font_r" width="97px"><span>*</span>出发地：</td>
	  <td width="100px">
	    <input name="fromStation" id="fromStation" type="hidden" />
		<input name="fromStationText" maxlength="15" value="简码/汉字" id="fromStationText" style="width:100px;" class="input_20txt_gray" type="text" />
	  </td>
	  <td class="font_r" width="64px"><span>*</span>目的地：</td>
	  <td width="100px">
	    <input name="toStation" id="toStation" type="hidden" />
		<input name="toStationText" maxlength="15" value="简码/汉字" id="toStationText" style="width:100px;" class="input_20txt_gray" type="text" />
	  </td>
	</tr>
  </tbody>
</table>
</body>
</html>