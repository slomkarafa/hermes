var directives = angular.module('hermes.directives', []);

directives.directive('calendar', [function () {
  return {
    link: function (scope, elem, attrs) {
      scope.$watch(function () {
        return scope.$eval(attrs.daysBack);
      }, function (value) {
        const startDate = moment().subtract(parseInt(value), "days");
        const endDate = moment().add(1, "second");

        $('#' + attrs.id).datetimepicker({
          format: "YYYY-MM-DDTHH:mm:ssZ",
          ignoreReadonly: true,
          useCurrent: true,
          minDate: startDate,
          maxDate: endDate,
          sideBySide: true
        });
      });
    }
  };
}]);