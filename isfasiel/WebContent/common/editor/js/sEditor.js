var oEditors = [];
function NaverSmartEditorUtil(){};
NaverSmartEditorUtil.prototype.className = "$NSE";
NaverSmartEditorUtil.prototype.name;
NaverSmartEditorUtil.prototype.sSkinURI = "/isfasiel/common/editor/skin.jsp";
NaverSmartEditorUtil.prototype.fCreator = "createSEditorInIFrame";
NaverSmartEditorUtil.prototype.load = function(name) {
	this.name = name;
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: this.name,
		sSkinURI: this.sSkinURI,
		fCreator: this.fCreator
	});		
};
NaverSmartEditorUtil.prototype.reset = function () {
	var value = document.getElementById(this.name).value;
	oEditors.getById[this.name].setIR(value);
};
NaverSmartEditorUtil.prototype.get = function () {
	return oEditors.getById[this.name].getIR();
};
NaverSmartEditorUtil.prototype.add = function(sHTML) {
	oEditors.getById[this.name].exec("PASTE_HTML", [sHTML]);
};
var $NSE = new NaverSmartEditorUtil(); 