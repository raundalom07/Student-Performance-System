import { useState } from "react";
import "../styles/Login.css";
import { useNavigate } from "react-router-dom";
import API from "../services/api";
import { useEffect } from "react";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    const token = localStorage.getItem("token");
    if (token) {
      navigate("/dashboard");
    }
  }, [navigate]);


const handleSubmit = async (e) => {
  e.preventDefault();

  try {

    const response = await API.post("/auth/login", {
      username,
      password,
    });

    const token = response.data;

    localStorage.setItem("token", token);

    alert("Login Successful");

    navigate("/dashboard");

  } catch (error) {
  console.log(error.response);
  console.log(error.response?.data);
  alert("Login Failed");
}
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