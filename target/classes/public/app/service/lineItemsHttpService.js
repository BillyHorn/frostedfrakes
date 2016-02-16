angular.module('app').service('lineItemsHttp', ['$http',
  function($http){

    // local var to hold end point name
    var lineItemsEndPoint = "/lineitems";

    function getLineItems(reportid) {
      return $http.get(lineItemsEndPoint + '/' + reportid);
    }

    function putLineItem(lineItem) {
      return $http.put(lineItemsEndPoint, lineItem);
    }

    function deleteLineItem(lineItemId) {
      return $http.delete(lineItemsEndPoint + '/' + lineItemId);
    }

    function getPendingLineItems(id){ // TODO what is this id most likely reportId
        return $http.get(lineItemsEndPoint + '/pending/' + id);
    }

    return {
      getLineItems : getLineItems,
      putLineItem : putLineItem,
      deleteLineItem : deleteLineItem,
      getPendingLineItems : getPendingLineItems
    }
  }]);
