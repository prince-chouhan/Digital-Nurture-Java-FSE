import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohortName, technology, duration, status }) => {
  // Define style for <h3> based on status
  const headingStyle = {
    color: status.toLowerCase() === 'ongoing' ? '#28a745' : '#007bff', // green : blue
    margin: '0 0 15px 0',
    fontSize: '1.4rem'
  };

  return (
    <div className={styles.box}>
      <h3 style={headingStyle}>{cohortName}</h3>
      <dl>
        <dt>Technology</dt>
        <dd>{technology}</dd>
        
        <dt>Duration</dt>
        <dd>{duration}</dd>
        
        <dt>Status</dt>
        <dd style={{ textTransform: 'capitalize' }}>{status}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
