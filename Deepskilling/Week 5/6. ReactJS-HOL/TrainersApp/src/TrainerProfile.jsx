import { useParams, Link } from "react-router-dom";
import { Trainer } from "./Trainers";

export default function TrainerProfile() {
  const { trainerName } = useParams();

  const selectedTrainer = Trainer.find(
    (t) => t.name.toLowerCase() === trainerName?.toLowerCase(),
  );

  if (!selectedTrainer) {
    return (
      <div style={{ padding: "20px" }}>
        <h2>Trainer Not Found</h2>
        <Link to="/">Go Back to List</Link>
      </div>
    );
  }

  return (
    <div>
      <h2> {selectedTrainer.name.toUpperCase()}</h2>
      <hr />
      <p>
        <strong> Email:</strong> {selectedTrainer.email}
      </p>
      <p>
        <strong> Contact:</strong> {selectedTrainer.number}
      </p>

      <h4> Professional Core Skills:</h4>
      <ul>
        {selectedTrainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
}
