export function openDaumPostcode(callback) {
    new daum.Postcode({
      oncomplete: function(data) {
        callback(data);
      }
    }).open();
  }
  