import { useState, useEffect } from 'react';
import { taskService } from '../services/taskService';

function Tasks() {
    const [tasks, setTasks] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [searchQuery, setSearchQuery] = useState('');

    useEffect(() => {
        fetchTasks();
    }, []);

    const fetchTasks = async () => {
        try {
            setLoading(true);
            const data = await taskService.getAll();
            setTasks(data);
            setError(null);
        } catch (err) {
            setError('Failed to load tasks. Please try again later.');
            setTasks([]);
        } finally {
            setLoading(false);
        }
    };

    const handleSearch = (e) => setSearchQuery(e.target.value);

    const filteredTasks = tasks.filter(t => 
        (t.taskName || '').toLowerCase().includes(searchQuery.toLowerCase()) || 
        (t.assignedUser || '').toLowerCase().includes(searchQuery.toLowerCase()) ||
        (t.project || '').toLowerCase().includes(searchQuery.toLowerCase())
    );

    return (
        <div>
            <div className="page-header">
                <h1 className="page-title">Task Management</h1>
                <div className="page-actions">
                    <input 
                        type="text" 
                        placeholder="Search tasks..." 
                        className="form-input"
                        value={searchQuery}
                        onChange={handleSearch}
                        style={{ width: '250px' }}
                    />
                    <button className="btn btn-primary">Add Task</button>
                </div>
            </div>

            {error && <div className="alert-error" style={{ marginBottom: '1rem' }}>{error}</div>}

            <div className="table-container">
                <table className="table">
                    <thead>
                        <tr>
                            <th>Task</th>
                            <th>Assigned User</th>
                            <th>Project</th>
                            <th>Status</th>
                            <th style={{ textAlign: 'right' }}>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {loading ? (
                            <tr>
                                <td colSpan="5" className="text-center" style={{ padding: '2rem' }}>Loading tasks...</td>
                            </tr>
                        ) : filteredTasks.length === 0 && !error ? (
                            <tr>
                                <td colSpan="5" className="text-center text-muted" style={{ padding: '2rem' }}>No tasks found.</td>
                            </tr>
                        ) : (
                            filteredTasks.map((task) => (
                                <tr key={task.id}>
                                    <td>{task.taskName}</td>
                                    <td>{task.assignedUser}</td>
                                    <td>{task.project}</td>
                                    <td>
                                        <select 
                                            className="form-input" 
                                            style={{ padding: '0.25rem 0.5rem', width: 'auto' }}
                                            defaultValue={task.status}
                                            disabled // Add onChange handler to call updateStatus when backend is ready
                                        >
                                            <option value="To Do">To Do</option>
                                            <option value="In Progress">In Progress</option>
                                            <option value="Done">Done</option>
                                        </select>
                                    </td>
                                    <td style={{ textAlign: 'right' }}>
                                        <div style={{ display: 'flex', gap: '0.5rem', justifyContent: 'flex-end' }}>
                                            <button className="btn btn-sm btn-secondary">Edit</button>
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
                        Showing {filteredTasks.length > 0 ? 1 : 0} to {filteredTasks.length} of {filteredTasks.length} entries
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

export default Tasks;
