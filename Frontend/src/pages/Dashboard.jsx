import { useAuth } from '../context/AuthContext';

function Dashboard() {
    const { user } = useAuth();

    return (
        <div>
            <div className="page-header">
                <h1 className="page-title">Dashboard</h1>
            </div>

            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(220px, 1fr))', gap: '1.5rem', marginBottom: '2rem' }}>
                <div className="stat-card">
                    <span className="stat-label">Total Projects</span>
                    <span className="stat-value">—</span>
                </div>
                <div className="stat-card">
                    <span className="stat-label">Total Tasks</span>
                    <span className="stat-value">—</span>
                </div>
                <div className="stat-card">
                    <span className="stat-label">Total Users</span>
                    <span className="stat-value">—</span>
                </div>
                <div className="stat-card">
                    <span className="stat-label">Completed Tasks</span>
                    <span className="stat-value">—</span>
                </div>
            </div>

            <div className="table-container" style={{ padding: '2rem' }}>
                <p className="text-muted">
                    Welcome back, <strong>{user?.name || 'User'}</strong>. Select a section from the sidebar to get started.
                </p>
            </div>
        </div>
    );
}

export default Dashboard;
