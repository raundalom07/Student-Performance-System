import { useState } from "react";
import { useNavigate } from "react-router-dom";
import API from "../services/api";

function AddStudent() {

  const navigate = useNavigate();

  const [student, setStudent] = useState({
    name: "",
    attendance: "",
    internalMarks: "",
    previousCgpa: "",
    studyHours: ""
  });

  const handleChange = (e) => {
    setStudent({
      ...student,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {

    e.preventDefault();

    try {

      const token = localStorage.getItem("token");

      await API.post(
        "/api/v1/students",
        student,
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }
      );

      alert("Student Added Successfully");

      navigate("/students");

    } catch (error) {
      console.error(error);
      alert("Failed to add student");
    }
  };

  return (
    <div className="container mt-4">

      <h2 className="mb-4">Add Student</h2>

      <form onSubmit={handleSubmit}>

        <div className="mb-3">
          <label>Name</label>
          <input
            type="text"
            name="name"
            className="form-control"
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label>Attendance</label>
          <input
            type="number"
            name="attendance"
            className="form-control"
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label>Internal Marks</label>
          <input
            type="number"
            name="internalMarks"
            className="form-control"
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label>Previous CGPA</label>
          <input
            type="number"
            step="0.1"
            name="previousCgpa"
            className="form-control"
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label>Study Hours</label>
          <input
            type="number"
            name="studyHours"
            className="form-control"
            onChange={handleChange}
            required
          />
        </div>

        <button
          type="submit"
          className="btn btn-success"
        >
          Save Student
        </button>

      </form>

    </div>
  );
}

export default AddStudent;