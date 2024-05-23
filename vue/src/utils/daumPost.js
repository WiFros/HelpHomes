export function openDaumPostcode(callback) {
    new daum.Postcode({
      oncomplete: function(data) {
        console.log(data);
        callback(data);
      }
    }).open();
  }
  