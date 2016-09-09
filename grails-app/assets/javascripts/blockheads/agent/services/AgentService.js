;(function () {
    'use strict';
    angular.module('blockheads.agent').factory('agentService',
        function ($resource, $window, $q) {
            var agent // save logged in
            function setAgent(agent) {
                agent = agent;
            }
            function getAgent(agent) {
                agent = agent;
            }

            var service = {
                setAgent: setAgent,
                getAgent: getAgent
            };

            return service;
        });
})();
