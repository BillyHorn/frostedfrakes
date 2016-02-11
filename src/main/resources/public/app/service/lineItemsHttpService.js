angular.module('app').service('lineItemsHttp', ['$http',
function($http){

  // local var to hold end point name
  var lineItemsEndPoint = "/lineitems";
  var lineItems = [];

  function getReceipts(counter){
    $http.get("/getReceipt/lineItem/" +  lineItems[counter].lineItemId).then(function(response){

      var receiptData = response.data;

      lineItems[counter].receipts = receiptData;

    });
  }

  function getLineItems(reportid) {
    return $http.get(lineItemsEndPoint + '/' + reportid).then(function(response){

      lineItems = response.data;

      for (var i = 0; i<lineItems.length; i++) {
        getReceipts(i);
      }

      console.log(lineItems);
      
      return lineItems;
    });
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
  };
}]);
