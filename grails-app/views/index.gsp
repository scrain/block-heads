<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>Simply Carrots</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <style type="text/css">
    [ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
        display: none !important;
    }
    </style>

    <asset:stylesheet src="application.css"/>
    <link href="https://lipis.github.io/bootstrap-social/assets/css/font-awesome.css" rel="stylesheet">
    <link href="https://lipis.github.io/bootstrap-social/bootstrap-social.css" rel="stylesheet" >
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <script type="text/javascript">
        window.contextPath = "${request.contextPath}";
    </script>

    <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="static/javascript/vendor/app.min.js"></script>

</head>

<body ng-app="blockheads" ng-controller="IndexController as indexCtrl">

<div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="navbar-header">
            <div class="navbar-brand" style="height:125px;">
                <div class="row">
                    <div class="col-lg-3">
                        <img src="assets/logo_white.png" alt="Simply Carrots" style="width:192px;height:78px;">
                    </div>
                    <div class="col-lg-4">
                    </div>
                    <div class="col-lg-5">
                        <p align="center" style="color:#FFF;line-height:40px;font-size:140%;"><b>Incentives you want. Promises you trust.</b></p>
                    </div
                </div>
            </div>
        </div>
        %{--<div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;" uib-collapse="!navExpanded">--}%
        %{--<ul class="nav navbar-nav navbar-right">--}%
        %{--<li class="dropdown" uib-dropdown>--}%
        %{--<a href="#" class="dropdown-toggle" uib-dropdown-toggle role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>--}%
        %{--<ul class="dropdown-menu" uib-dropdown-menu>--}%
        %{--<li><a href="#">Environment: {{indexCtrl.applicationData.environment}}</a></li>--}%
        %{--<li><a href="#">App profile: {{indexCtrl.applicationData.appprofile}}</a></li>--}%
        %{--<li><a href="#">App version: {{indexCtrl.applicationData.appversion}}</a></li>--}%
        %{--<li role="separator" class="divider"></li>--}%
        %{--<li><a href="#">Grails version: {{indexCtrl.applicationData.grailsversion}}</a></li>--}%
        %{--<li><a href="#">Groovy version: {{indexCtrl.applicationData.groovyversion}}</a></li>--}%
        %{--<li><a href="#">JVM version: {{indexCtrl.applicationData.jvmversion}}</a></li>--}%
        %{--<li role="separator" class="divider"></li>--}%
        %{--<li><a href="#">Reloading active: {{indexCtrl.applicationData.reloadingagentenabled}}</a></li>--}%
        %{--</ul>--}%
        %{--</li>--}%
        %{--</ul>--}%
        %{--</div>--}%
    </div>
</div>

<div class="container">
    <div ui-view></div>
</div>

<br/>
<br/>
<br/>

<div class="row">
    <div class="col-md-12">
        <div class="footer" role="contentinfo"></div>
    </div>
</div>

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

</body>
<asset:javascript src="/blockheads/blockheads.js"/>

</html>
