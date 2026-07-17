import { Link } from "react-router-dom"; // 1. Import Link
import { Trainer } from "./Trainers";

export default function TrainersDetails() {
  return (
    <>
      <h2>Trainer Details</h2>
      {Trainer.map((trainer) => (
        <div key={trainer.name}>
          <Link to={`/trainers/${trainer.name.toLowerCase()}`}>
            <h3>{trainer.name}</h3>
          </Link>
        </div>
      ))}
    </>
  );
}
