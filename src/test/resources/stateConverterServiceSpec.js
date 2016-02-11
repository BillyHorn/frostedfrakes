describe("StateConverter", function() {

  beforeEach(module('app'));

  it("should work", function() {
    expect(true).toBe(true);
  });
  it("should have stateConverterService be defined", function() {
    expect(stateConverterService).toBeDefined();
  });
  it("should return saved when get string gets 1", function() {
    expect(stateConverterService.getString(1)).toEqual("saved");
  });
});
