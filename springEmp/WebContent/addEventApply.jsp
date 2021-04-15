<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	Button1 = function(elementid) {
		this.element = document.getElementById(elementid);
		this.element.addEventListener("mouseover", this.doMouseOver);
		this.element.addEventListener("mouseout", this.doMouseOut);
	}
	
	
	Button1.prototype = {
			doMouseOver : function(e) {
				console.log('over');
				this.element.style.backgroundColor = '#999';
			}
		,
			doMouseOut : function(e) {
				console.log('out');
				this.element.style.backgroundColor = '#fff';
			}
	}
	
	Button2 = function(elementid) {
		var btn = this;
		var overFunc = function() {
			btn.doMouseOver.apply(btn, arguments);
		}
		var outFunc = function() {
			btn.doMouseOut.apply(btn, arguments);
		}		
		this.element = document.getElementById(elementid);
		this.element.style.border="1px solid blue";
		this.element.addEventListener("mouseover", overFunc);
		this.element.addEventListener("mouseout", outFunc);
	}
	
	
	Button2.prototype = {
			doMouseOver : function(e) {
				console.log('over');
				this.element.style.backgroundColor = '#999';
			}
		,
			doMouseOut : function(e) {
				console.log('out');
				this.element.style.backgroundColor = '#fff';
			}
	}	
	
	window.onload = function() {
		var btn1 = new Button2('btn1');
		var btn2 = new Button2('btn2');
	}
</script>
</head>
<body>
    <span id='btn1' style="width:100px;height:100px;"> button1 </span>
	<span id='btn2' style="width:100px;height:100px;"> button2 </span>
</body>
</html>