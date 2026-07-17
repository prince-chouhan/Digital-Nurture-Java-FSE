import React from 'react';
import CohortDetails from './Components/CohortDetails';
import './App.css';

function App() {
  const cohorts = [
    { id: 1, name: 'Java Full Stack Engineering', technology: 'React & Spring Boot', duration: '6 Months', status: 'ongoing' },
    { id: 2, name: 'Cloud Native Development', technology: 'AWS & Microservices', duration: '4 Months', status: 'completed' },
    { id: 3, name: 'Data Engineering Bootcamp', technology: 'Python & Spark', duration: '5 Months', status: 'ongoing' },
    { id: 4, name: 'Frontend Masters', technology: 'Angular & TypeScript', duration: '3 Months', status: 'completed' },
  ];

  return (
    <div className="app-container">
      <header className="app-header">
        <h1>Cognizant Academy Cohorts</h1>
      </header>
      <main className="dashboard-grid">
        {cohorts.map(cohort => (
          <CohortDetails 
            key={cohort.id}
            cohortName={cohort.name}
            technology={cohort.technology}
            duration={cohort.duration}
            status={cohort.status}
          />
        ))}
      </main>
    </div>
  );
}

export default App;
