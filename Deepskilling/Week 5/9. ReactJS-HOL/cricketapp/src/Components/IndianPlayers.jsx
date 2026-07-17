import React from 'react';

const IndianPlayers = () => {
  // Destructuring Odd and Even team players
  const allPlayers = ['Sachin', 'Sehwag', 'Gambhir', 'Dravid', 'Yuvraj', 'Dhoni'];
  const [odd1, even1, odd2, even2, odd3, even3] = allPlayers;
  
  const oddTeam = [odd1, odd2, odd3];
  const evenTeam = [even1, even2, even3];

  // Merge feature of ES6
  const T20Players = ['Suresh Raina', 'Rohit Sharma', 'Virat Kohli'];
  const RanjiTrophyPlayers = ['Prithvi Shaw', 'Sarfaraz Khan', 'Yashasvi Jaiswal'];
  const mergedPlayers = [...T20Players, ...RanjiTrophyPlayers];

  return (
    <div className="component-card">
      <h2>Indian Players</h2>
      
      <div className="sections-container">
        <div className="section">
          <h3>Odd Team Players (Destructuring)</h3>
          <ul className="player-list">
            {oddTeam.map((player, index) => (
              <li key={index}>
                <span className="player-name">{player}</span>
              </li>
            ))}
          </ul>
        </div>
        
        <div className="section">
          <h3>Even Team Players (Destructuring)</h3>
          <ul className="player-list">
            {evenTeam.map((player, index) => (
              <li key={index}>
                <span className="player-name">{player}</span>
              </li>
            ))}
          </ul>
        </div>
      </div>
      
      <div className="section full-width">
        <h3>Merged Team (Spread Operator)</h3>
        <div className="merged-grid">
          {mergedPlayers.map((player, index) => (
            <div key={index} className="merged-chip">{player}</div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default IndianPlayers;
