import React from 'react';
import Carousel from './Carousel';
import './Carousel.css';

const App = () => {
  const images = [
    'https://fastly.picsum.photos/id/125/200/300.jpg?hmac=yLvRBwUcr6LYWuGaGk05UjiU5vArBo3Idr3ap5tpSxU',
    'https://fastly.picsum.photos/id/362/200/300.jpg?hmac=YjZiJWaqrdKL4xFhgrjDw4Ic2tPzNLV975FWRb8td0s',
    'https://fastly.picsum.photos/id/542/200/300.jpg?hmac=qD8M4ejDPlEc69pGT21BzB7CDiWOcElb_Ke7V8POjm8',
  ];

  return (
    <div className="App">
      <h1>Instagram-Like Carousel React Component</h1>
      <Carousel images={images} />
    </div>
  );
};

export default App;