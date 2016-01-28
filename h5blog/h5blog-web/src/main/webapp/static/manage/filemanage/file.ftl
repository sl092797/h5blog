<!doctype html>
<html lang="en" data-ng-app="FileManagerApp">
<head>
<!--
    * Angular FileManager v1.4.4 (https://github.com/joni2back/angular-filemanager)
    * Jonas Sciangula Street <joni2back@gmail.com>
    * Licensed under MIT (https://github.com/joni2back/angular-filemanager/blob/master/LICENSE)
  -->
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>angular-filemanager</title>

<!-- third party -->
<script src="${BASE_PATH}/static/manage/filemanage/bower_components/angular/angular.min.js"></script>
<script
	src="${BASE_PATH}/static/manage/filemanage/bower_components/angular-translate/angular-translate.min.js"></script>
<script src="${BASE_PATH}/static/manage/filemanage/bower_components/angular-cookies/angular-cookies.min.js"></script>
<script src="${BASE_PATH}/static/manage/filemanage/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${BASE_PATH}/static/manage/filemanage/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${BASE_PATH}/static/manage/filemanage/bower_components/bootswatch/paper/bootstrap.min.css" />
<!-- /third party -->

<!-- Uncomment if you need to use raw source code  -->
    <script src="${BASE_PATH}/static/manage/filemanage/src/js/app.js"></script>
    <script src="${BASE_PATH}/static/manage/filemanage/src/js/directives/directives.js"></script>
    <script src="${BASE_PATH}/static/manage/filemanage/src/js/filters/filters.js"></script>
    <script src="${BASE_PATH}/static/manage/filemanage/src/js/providers/config.js"></script>
    <script src="${BASE_PATH}/static/manage/filemanage/src/js/entities/chmod.js"></script>
    <script src="${BASE_PATH}/static/manage/filemanage/src/js/entities/item.js"></script>
    <script src="${BASE_PATH}/static/manage/filemanage/src/js/services/filenavigator.js"></script>
    <script src="${BASE_PATH}/static/manage/filemanage/src/js/services/fileuploader.js"></script>
    <script src="${BASE_PATH}/static/manage/filemanage/src/js/providers/translations.js"></script>
    <script src="${BASE_PATH}/static/manage/filemanage/src/js/controllers/main.js"></script>
    <script src="${BASE_PATH}/static/manage/filemanage/src/js/controllers/selector-controller.js"></script>
    <link href="${BASE_PATH}/static/manage/filemanage/src/css/animations.css" rel="stylesheet">
    <link href="${BASE_PATH}/static/manage/filemanage/src/css/dialogs.css" rel="stylesheet">
    <link href="${BASE_PATH}/static/manage/filemanage/src/css/main.css" rel="stylesheet">


<!-- Comment if you need to use raw source code -->
<!-- <link href="dist/angular-filemanager.min.css" rel="stylesheet">
<script src="dist/angular-filemanager.min.js"></script> -->
<!-- /Comment if you need to use raw source code -->

<script type="text/javascript">
	//example to override angular-filemanager default config
	angular.module('FileManagerApp').config(
			[ 'fileManagerConfigProvider', function(config) {
				var defaults = config.$get();
				config.set({
					appName : '文件管理',
					listUrl : '${BASE_PATH}/manage/file/option.htm',
					uploadUrl : '${BASE_PATH}/manage/file/option.htm',
					renameUrl : '${BASE_PATH}/manage/file/option.htm',
					copyUrl: '${BASE_PATH}/manage/file/option.htm',
		            removeUrl: '${BASE_PATH}/manage/file/option.htm',
		            editUrl: '${BASE_PATH}/manage/file/option.htm',
		            getContentUrl: '${BASE_PATH}/manage/file/option.htm',
		            createFolderUrl: '${BASE_PATH}/manage/file/option.htm',
		            downloadFileUrl: '${BASE_PATH}/manage/file/download.htm',
		            compressUrl: '${BASE_PATH}/manage/file/option.htm',
		            extractUrl: '${BASE_PATH}/manage/file/option.htm',
		            permissionsUrl: '${BASE_PATH}/manage/file/option.htm',
		            tplPath: '${BASE_PATH}/static/manage/filemanage/src/templates',
					allowedActions : angular.extend(defaults.allowedActions, {
						remove : true
					})
				});
			} ]);
</script>
</head>

<body class="ng-cloak">
	<angular-filemanager></angular-filemanager>
</body>
</html>
