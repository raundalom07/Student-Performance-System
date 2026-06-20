import { useEffect, useState } from "react";
import { getStudents } from "../services/studentService";

function Dashboard() {

  const [totalStudents, setTotalStudents] = useState(0);
  const [avgAttendance, setAvgAttendance] = useState(0);
  const [avgMarks, setAvgMarks] = useState(0);
  const [avgCgpa, setAvgCgpa] = useState(0);

  useEffect(() => {
    loadDashboard();
  }, []);

  const loadDashboard = async () => {

    try {

      const response = await getStudents();

      const students =
        response.data.data.content;

      setTotalStudents(students.length);

      const attendance =
        students.reduce(
          (sum, s) => sum + s.attendance,
          0
        ) / students.length;

      const marks =
        students.reduce(
          (sum, s) => sum + s.internalMarks,
          0
        ) / students.length;

      const cgpa =
        students.reduce(
          (sum, s) => sum + s.previousCgpa,
          0
        ) / students.length;

      setAvgAttendance(attendance.toFixed(1));
      setAvgMarks(marks.toFixed(1));
      setAvgCgpa(cgpa.toFixed(1));

    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="container mt-4">

      <h2>Dashboard</h2>

      <div className="row mt-4">

        <div className="col-md-3">
          <div className="card shadow">
            <div className="card-body">
              <h5>Total Students</h5>
              <h2>{totalStudents}</h2>
            </div>
          </div>
        </div>

        <div className="col-md-3">
          <div className="card shadow">
            <div className="card-body">
              <h5>Average Attendance</h5>
              <h2>{avgAttendance}%</h2>
            </div>
          </div>
        </div>

        <div className="col-md-3">
          <div className="card shadow">
            <div className="card-body">
              <h5>Average Marks</h5>
              <h2>{avgMarks}</h2>
            </div>
          </div>
        </div>

        <div className="col-md-3">
          <div className="card shadow">
            <div className="card-body">
              <h5>Average CGPA</h5>
              <h2>{avgCgpa}</h2>
            </div>
          </div>
        </div>

      </div>

    </div>
  );
}

export default Dashboard;