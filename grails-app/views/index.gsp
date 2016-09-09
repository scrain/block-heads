<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>Will Sell Insurance for Food</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <style type="text/css">
        [ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
            display: none !important;
        }
    </style>

<asset:stylesheet src="application.css"/>

<asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
<!-- link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,800,700,400italic,600italic,700italic,800italic,300italic" rel="stylesheet" type="text/css" -->

<script type="text/javascript">
    window.contextPath = "${request.contextPath}";
</script>
</head>

<body ng-app="blockheads" ng-controller="IndexController as indexCtrl">

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div>
            <div class="navbar-header">
                <font color="white">WSIFF</font>
            </div>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;" uib-collapse="!navExpanded">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown" uib-dropdown>
                        <a href="#" class="dropdown-toggle" uib-dropdown-toggle role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
                        <ul class="dropdown-menu" uib-dropdown-menu>
                            <li><a href="#">Environment: {{indexCtrl.applicationData.environment}}</a></li>
                            <li><a href="#">App profile: {{indexCtrl.applicationData.appprofile}}</a></li>
                            <li><a href="#">App version: {{indexCtrl.applicationData.appversion}}</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Grails version: {{indexCtrl.applicationData.grailsversion}}</a></li>
                            <li><a href="#">Groovy version: {{indexCtrl.applicationData.groovyversion}}</a></li>
                            <li><a href="#">JVM version: {{indexCtrl.applicationData.jvmversion}}</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Reloading active: {{indexCtrl.applicationData.reloadingagentenabled}}</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

<div class="container">



    <div ui-view></div>

    <!-- prev/next nav -->
    <div class="row">
        <ul class="pager">
            <li class="previous"><a href="#">Previous</a></li>
            <li class="next disabled"><a href="#">Next</a></li>
        </ul>
    </div>

    <!-- progress bar -->
    <div class="progress">
        <div class="progress-bar progress-bar-success" style="width: 40%">40%</div>

        <div class="progress-bar progress-bar-warning" style="width: 25%">25%</div>
    </div>


</div>

<div class="footer" role="contentinfo"></div>

<div id="spinner" class="spinner" style="display:none;">
<g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="/blockheads/blockheads.js"/>
<script type="javascript" src="static/javascript/vendor/app.min.js" />
</body>
</html>
