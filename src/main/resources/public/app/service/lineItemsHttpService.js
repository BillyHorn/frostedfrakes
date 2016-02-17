angular.module('app').service('lineItemsHttp', ['$http',
function($http){

  // local var to hold end point name
  var lineItemsEndPoint = "/lineitems";
  var lineItems = [];

  /* this function gets receipts (SURPRISE). the counter is the 'i' from the
     loop where this function is called */
  function getReceipts(counter){
    // get them receipts, based on the line item.
    $http.get("/getReceipt/lineItem/" +  lineItems[counter].lineItemId).then(function(response){

      // pull out the data
      var receiptData = response.data;

      // and associate that receipt with the line item
      lineItems[counter].receipts = receiptData;

    });
  }

  // getting them line items.
  function getLineItems(reportid) {
    return $http.get(lineItemsEndPoint + '/' + reportid).then(function(response){
      // snag the line items form the db
      lineItems = response.data;

      for (var i = 0; i<lineItems.length; i++) {
        // loop over and call the above function
        getReceipts(i);
      }

      // send them back!
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
