import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import TrainersDetails from "./TrainersDetails";
import TrainerProfile from "./TrainerProfile";

export default function App() {
  return (
    <>
      <h1>My Academy Trainers App</h1>
      <BrowserRouter>
        <nav>
          <Link to="/">Home</Link> | <Link to="/trainers">TrainersDetails</Link>
        </nav>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersDetails />} />
          <Route path="/trainers/:trainerName" element={<TrainerProfile />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}
