import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat Kohli', score: 105 },
    { name: 'Rohit Sharma', score: 85 },
    { name: 'KL Rahul', score: 45 },
    { name: 'Suryakumar Yadav', score: 95 },
    { name: 'Hardik Pandya', score: 55 },
    { name: 'Rishabh Pant', score: 75 },
    { name: 'Ravindra Jadeja', score: 35 },
    { name: 'Jasprit Bumrah', score: 15 },
    { name: 'Mohammed Shami', score: 10 },
    { name: 'Yuzvendra Chahal', score: 5 },
    { name: 'Bhuvneshwar Kumar', score: 25 },
  ];

  // ES6 Arrow function and filter
  const highScorers = players.filter(player => player.score >= 70);
  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div className="component-card">
      <h2>List of Players</h2>
      
      <div className="sections-container">
        <div className="section">
          <h3>Players with Score <span className="highlight">70+</span></h3>
          <ul className="player-list">
            {/* ES6 Map */}
            {highScorers.map((player, index) => (
              <li key={index}>
                <span className="player-name">{player.name}</span>
                <span className="player-score badge-high">{player.score}</span>
              </li>
            ))}
          </ul>
        </div>
        
        <div className="section">
          <h3>Players with Score <span className="highlight-danger">&lt; 70</span></h3>
          <ul className="player-list">
            {lowScorers.map((player, index) => (
              <li key={index}>
                <span className="player-name">{player.name}</span>
                <span className="player-score badge-low">{player.score}</span>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default ListofPlayers;
