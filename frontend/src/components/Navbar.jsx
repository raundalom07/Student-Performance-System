import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav>
      <Link to="/login">Login</Link> |{" "}
      <Link to="/dashboard">Dashboard</Link> |{" "}
      <Link to="/students">Students</Link> |{" "}
      <Link to="/predict">Predict</Link>
    </nav>
  );
}

export default Navbar;