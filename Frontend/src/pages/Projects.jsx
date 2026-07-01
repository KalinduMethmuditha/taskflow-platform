import { useState, useEffect } from 'react';
import { projectService } from '../services/projectService';

function Projects() {
    const [projects, setProjects] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [searchQuery, setSearchQuery] = useState('');

    useEffect(() => {
        fetchProjects();
    }, []);

    const fetchProjects = async () => {
        try {
            setLoading(true);
            const data = await projectService.getAll();
            setProjects(data);
            setError(null);
        } catch (err) {
            setError('Failed to load projects. Please try again later.');
            setProjects([]);
        } finally {
            setLoading(false);
        }
    };

    const handleSearch = (e) => setSearchQuery(e.target.value);

    const filteredProjects = projects.filter(p => 
        (p.projectName || '').toLowerCase().includes(searchQuery.toLowerCase()) || 
        (p.owner || '').toLowerCase().includes(searchQuery.toLowerCase()) ||
        (p.status || '').toLowerCase().includes(searchQuery.toLowerCase())
    );

    return (
        <div>
            <div className="page-header">
                <h1 className="page-title">Projects</h1>
                <div className="page-actions">
                    <input 
                        type="text" 
                        placeholder="Search projects..." 
                        className="form-input"
                        value={searchQuery}
                        onChange={handleSearch}
                        style={{ width: '250px' }}
                    />
                    <button className="btn btn-primary">Create Project</button>
                </div>
            </div>

            {error && <div className="alert-error" style={{ marginBottom: '1rem' }}>{error}</div>}

            <div className="table-container">
                <table className="table">
                    <thead>
                        <tr>
                            <th>Project Name</th>
                            <th>Owner</th>
                            <th>Status</th>
                            <th>Description</th>
                            <th style={{ textAlign: 'right' }}>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {loading ? (
                            <tr>
                                <td colSpan="5" className="text-center" style={{ padding: '2rem' }}>Loading projects...</td>
                            </tr>
                        ) : filteredProjects.length === 0 && !error ? (
                            <tr>
                                <td colSpan="5" className="text-center text-muted" style={{ padding: '2rem' }}>No projects found.</td>
                            </tr>
                        ) : (
                            filteredProjects.map((project) => (
                                <tr key={project.id}>
                                    <td>{project.projectName}</td>
                                    <td>{project.owner}</td>
                                    <td>
                                        <span className={`badge ${project.status === 'Active' ? 'badge-primary' : 'badge-secondary'}`}>
                                            {project.status}
                                        </span>
                                    </td>
                                    <td className="text-muted">{project.description}</td>
                                    <td style={{ textAlign: 'right' }}>
                                        <div style={{ display: 'flex', gap: '0.5rem', justifyContent: 'flex-end' }}>
                                            <button className="btn btn-sm btn-secondary">Update</button>
                                            <button className="btn btn-sm btn-danger">Delete</button>
                                        </div>
                                    </td>
                                </tr>
                            ))
                        )}
                    </tbody>
                </table>
                <div className="pagination">
                    <div className="pagination-info">
                        Showing {filteredProjects.length > 0 ? 1 : 0} to {filteredProjects.length} of {filteredProjects.length} entries
                    </div>
                    <div className="page-actions">
                        <button className="btn btn-sm btn-secondary" disabled>Previous</button>
                        <button className="btn btn-sm btn-secondary" disabled>Next</button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Projects;
