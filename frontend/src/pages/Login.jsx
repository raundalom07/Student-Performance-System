import { useState } from "react";
import "../styles/Login.css";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    console.log({
      username,
      password,
    });
  };

  return (
    <div className="login-container">

      <div className="card login-card">

        <div className="card-body">

          <h2 className="login-title">
            Student Performance System
          </h2>

          <form onSubmit={handleSubmit}>

            <div className="mb-3">
              <label className="form-label">
                Username
              </label>

              <input
                type="text"
                className="form-control"
                placeholder="Enter username"
                value={username}
                onChange={(e) =>
                  setUsername(e.target.value)
                }
              />
            </div>

            <div className="mb-3">
              <label className="form-label">
                Password
              </label>

              <input
                type="password"
                className="form-control"
                placeholder="Enter password"
                value={password}
                onChange={(e) =>
                  setPassword(e.target.value)
                }
              />
            </div>

            <button
              type="submit"
              className="btn btn-primary w-100"
            >
              Login
            </button>

          </form>

        </div>

      </div>

    </div>
  );
}

export default Login;