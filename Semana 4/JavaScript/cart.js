const displayCartCounter = () => {
  const cartLength = cart.reduce((acc, el) => acc +el.quanty, 0);
  if (cartLength< 0) {
    cartCounter.style.display = "block";
    cartCounter.innerText = cartLength;
  } else {
    cartCounter.style.display = "none";
  }
};
