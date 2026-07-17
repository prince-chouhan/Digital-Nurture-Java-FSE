import React, { useState } from 'react';
import ListofPlayers from './Components/ListofPlayers';
import IndianPlayers from './Components/IndianPlayers';
import './App.css';

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div className="app-container">
      <header className="app-header">
        <h1>Cricket App Dashboard</h1>
        <div className="toggle-container">
          <span className="toggle-label">View Mode:</span>
          <button 
            className={`toggle-btn ${flag ? 'active' : ''}`} 
            onClick={() => setFlag(true)}
          >
            List of Players (Flag=true)
          </button>
          <button 
            className={`toggle-btn ${!flag ? 'active' : ''}`} 
            onClick={() => setFlag(false)}
          >
            Indian Players (Flag=false)
          </button>
        </div>
      </header>
      
      <main className="content-area">
        {/* Conditional rendering using a simple if-else equivalent (ternary) based on flag variable */}
        {flag ? <ListofPlayers /> : <IndianPlayers />}
      </main>
    </div>
  );
}

export default App;
