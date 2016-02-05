angular.module('app').service('lineItemsHttp', ['$http',
  function($http){
    function getLineItems(reportid) {
      return $http.get('/lineitems/' + reportid);
    }

    function putLineItem(lineItem) {
      return $http.put('/lineitems', lineItem);
    }

    function deleteLineItem(lineItemId) {
      return $http.delete('/lineitems/' + lineItemId);
    }

    function getPendingLineItems(id){
        return $http.get('/lineitems/pending/' + id);
    }

    return {
      getLineItems : getLineItems,
      putLineItem : putLineItem,
      deleteLineItem : deleteLineItem,
      getPendingLineItems : getPendingLineItems
    }
  }]);
