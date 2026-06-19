function Dashboard() {
  return (
    <div className="container mt-4">
      <h2>Dashboard</h2>

      <div className="row mt-4">

        <div className="col-md-4">
          <div className="card shadow">
            <div className="card-body">
              <h5>Total Students</h5>
              <h2>3</h2>
            </div>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow">
            <div className="card-body">
              <h5>Predictions</h5>
              <h2>15</h2>
            </div>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow">
            <div className="card-body">
              <h5>Average CGPA</h5>
              <h2>8.2</h2>
            </div>
          </div>
        </div>

      </div>
    </div>
  );
}

export default Dashboard;