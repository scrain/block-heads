//= wrapped

angular
    .module("blockheads.index")
    .factory("applicationDataFactory", applicationDataFactory);

function applicationDataFactory($http) {
    return {
        get: function() {
            return $http({method: "GET", url: "application/index"});
        }
    }
}

