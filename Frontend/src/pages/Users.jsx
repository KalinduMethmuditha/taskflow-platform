import { useState, useEffect } from 'react';
import { userService } from '../services/userService';

function Users() {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [searchQuery, setSearchQuery] = useState('');

    useEffect(() => {
        fetchUsers();
    }, []);

    const fetchUsers = async () => {
        try {
            setLoading(true);
            const data = await userService.getAll();
            setUsers(data);
            setError(null);
        } catch (err) {
            setError('Failed to load users. Please try again later or check if the backend is running.');
            setUsers([]);
        } finally {
            setLoading(false);
        }
    };

    const handleSearch = (e) => {
        setSearchQuery(e.target.value);
    };

    // Filter users based on search
    const filteredUsers = users.filter(user => 
        (user.fullName || '').toLowerCase().includes(searchQuery.toLowerCase()) || 
        (user.email || '').toLowerCase().includes(searchQuery.toLowerCase()) ||
        (user.role || '').toLowerCase().includes(searchQuery.toLowerCase())
    );

    return (
        <div>
            <div className="page-header">
                <h1 className="page-title">Users Management</h1>
                <div className="page-actions">
                    <input 
                        type="text" 
                        placeholder="Search users..." 
                        className="form-input"
                        value={searchQuery}
                        onChange={handleSearch}
                        style={{ width: '250px' }}
                    />
                    <button className="btn btn-primary">Add User</button>
                </div>
            </div>

            {error && (
                <div className="alert-error" style={{ marginBottom: '1rem' }}>
                    {error}
                </div>
            )}

            <div className="table-container">
                <table className="table">
                    <thead>
                        <tr>
                            <th>Full Name</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th style={{ textAlign: 'right' }}>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {loading ? (
                            <tr>
                                <td colSpan="4" className="text-center" style={{ padding: '2rem' }}>
                                    Loading users...
                                </td>
                            </tr>
                        ) : filteredUsers.length === 0 && !error ? (
                            <tr>
                                <td colSpan="4" className="text-center text-muted" style={{ padding: '2rem' }}>
                                    No users found.
                                </td>
                            </tr>
                        ) : (
                            filteredUsers.map((user) => (
                                <tr key={user.id}>
                                    <td>{user.fullName}</td>
                                    <td>{user.email}</td>
                                    <td>{user.role}</td>
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
                        Showing {filteredUsers.length > 0 ? 1 : 0} to {filteredUsers.length} of {filteredUsers.length} entries
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

export default Users;
